package Exam.Amazon;

import java.util.*;

public class FileSystem {
    class File{
        boolean isFile=false;
        Map<String,File> children=new HashMap<>();
        String content="";
    }
    File root;
    public FileSystem() {
            root=new File();
    }

    public void mkdir(String path)
    {
        traverse(path);

    }
    public void addContentToFile(String filePath, String content) {
       File curr= traverse(filePath);
       curr.isFile=true;
       curr.content+=content;
    }
    public String readContentFromFile(String filePath) {
        File curr= traverse(filePath);
        return curr.content;
    }

    private File traverse(String path) {
        String[] dirs=path.split("/");
        File curr=root;
        for(String dir:dirs)
        {
            if (dir.length() == 0) continue;
            curr.children.putIfAbsent(dir,new File());
            curr=curr.children.get(dir);
        }
        return curr;
    }
    public List<String> ls(String path) {
        String[] dirs=path.split("/");
        File curr=root;
        String name="";
        List <String> res=new ArrayList<>();
        for(String dir:dirs)
        {
            if (dir.length() == 0) continue;
            if(!curr.children.containsKey(dir)) return res;
            curr=curr.children.get(dir);
            name=dir;
        }
        if(curr.isFile)
            res.add(name);
        else
        {
            for(String str:curr.children.keySet())
            {
                res.add(str);

            }
            Collections.sort(res);
        }
        return res;

    }


    public static void main(String[] args) {
        FileSystem f=new FileSystem();
        f.mkdir("/a/b/c");
        f.mkdir("/a/b/e");
        f.mkdir("/a/b/f");
        f.addContentToFile("/a/b/c/d","hello");
        String content=f.readContentFromFile("/a/b/c/d");
        System.out.println(f.ls("/a/b"));
    }

}
