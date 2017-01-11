package my.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class File_Helper {
    
    public static long copy(String srcFilename, OutputStream os) throws Exception {
        InputStream is = new FileInputStream(srcFilename);
        try {
            long total = copy(is, os);
            is.close();
            return total;
        } catch (Exception ex) {
            is.close();
            throw ex;
        }
    }
    
    public static long copy(InputStream is, OutputStream os) throws Exception {
        byte[] buffer = new byte[1025];
        int read;
        long total = 0;
        while((read=is.read(buffer, 0, 1024))>0) {
            os.write(buffer, 0, read);
            total += read;
        }
        return total;
    }

    public static long copy(InputStream is, File dest) throws Exception {
        OutputStream os = new FileOutputStream(dest);
        try {
            long total = copy(is, os);
            os.close();
            return total;
        } catch (Exception ex) {
            os.close();
            throw ex;
        }
    }

    public static long copy(File src, File dest) throws Exception {
        InputStream is = new FileInputStream(src);
        try {
            long total = copy(is, dest);
            is.close();
            return total;
        } catch (Exception ex) {
            is.close();
            throw ex;
        }
    }
    
    public static long copy(String src, File dest) throws Exception {
        InputStream is = new FileInputStream(src);
        try {
            long total = copy(is, dest);
            is.close();
            return total;
        } catch (Exception ex) {
            is.close();
            throw ex;
        }
    }
    
    public static long copy(File src, String dest) throws Exception {
        InputStream is = new FileInputStream(src);
        File destFile = new File(dest);
        if (!destFile.exists()) {
            destFile.createNewFile();
        } else {
            destFile.delete();
            destFile.createNewFile();
        }
        
        try {
            long total = copy(is, destFile);
            is.close();
            return total;
        } catch (Exception ex) {
            is.close();
            throw ex;
        }
    }

    public static long copy(InputStream is, OutputStream os, long start, long size) {
        byte[] buffer = new byte[1025];
        int read = 1024;
        long total = 0;
        try {
            is.skip(start);
            if (read > size) read = (int)size;
            while(read > 0 && (read=is.read(buffer, 0, read))>0) {
                    os.write(buffer, 0, read);
                total += read;
                if (size - total > 1024L) {
                    read = 1024;
                } else {
                    read = (int)(size-total);
                }
            }
            return total;
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return total;
    }

    public static boolean copy(String src, String dest) throws Exception {
        OutputStream os;
        InputStream is = new FileInputStream(src);
        try {
            os = new FileOutputStream(dest);
        } catch (FileNotFoundException ex) {
            is.close();
            throw ex;
        }
        try {
            copy(is, os);
        } catch (Exception ex) {
            is.close();
            os.close();
            throw ex;
        }
        os.close();
        return true;
    }

    public static File mkdir(File parent, String subpath) {
        if (mkdir(parent)) {
            File file = new File(parent, subpath);
            if (mkdir(file)) {
                return file;
            }
        }
        return null;
    }

    public static File mkdir(String parent, String subpath) {
        return mkdir(new File(parent), subpath);
    }

    public static File mkdir(String path) {
        File file = new File(path);
        if (mkdir(file)) {
            return file;
        }
        return null;
    }

    public static boolean mkdir(File file) {
        if (file != null) {
            if (!file.isDirectory()) {
                return file.mkdirs();
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean clean(String path) {
        return clean(new File(path));
    }

    public static void clean(File[] files) {
        for (File file: files) {
            clean(file);
        }
    }

    public static void clean(List<File> files) {
        for (File file: files) {
            clean(file);
        }
    }

    public static boolean clean(File file) {
        boolean result = true;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                for (File item : children) {
                    result = (result && delete(item));
                }
                return result;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean delete(String path) {
        return delete(new File(path));
    }

    public static boolean delete(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                clean(file);
                return file.delete();
            } else if (file.isFile()) {
                return file.delete();
            }
        }
        return true;
    }
	
    static public File createNewFile(List<File> parents, String subdir, String filename, Long spaceLimit) {
        //long limit = 1000 * 1000 * 50;
        long limit = 0;
        if (spaceLimit != null && spaceLimit > 0l) {
            limit = spaceLimit;
        }

        File result;
        if (parents != null && parents.size()>0) {
            for(File parent : parents) {
                if (parent.getFreeSpace() > limit) {
                    File dir = parent;
                    if (subdir != null && !subdir.isEmpty()) {
                        dir = File_Helper.mkdir(subdir);
                    }
                    if (dir != null) {
                        result = new File(dir, filename);
                        if (result.exists()) {
                            result.delete();
                        }
                        try {
                            if (result.createNewFile())
                                return result;
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                    }
                }
            }
        }
        return null;
    }
	
    static public File createNewFile(List<File> parents, String subdir, String filename) {
        return createNewFile(parents, subdir, filename, null);
    }

    static public File createNewFile(List<File> parents, String filename) {
        return createNewFile(parents, null, filename);
    }

    static public File getFile(List<File> parents, String subdir, String filename) {
        File result;
        if (parents != null && parents.size()>0) {
            for(File parent : parents) {
                File dir = parent;
                if (subdir != null && !subdir.isEmpty()) {
                    dir = new File(parent, subdir);
                }
                if (dir != null &&  dir.isDirectory() && dir.exists()) {
                    result = new File(dir, filename);
                    if(result.exists()) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    static public File getFile(List<File> parents, String filename) {
        return getFile(parents, null, filename);
    }
	
}
