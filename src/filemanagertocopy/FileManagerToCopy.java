
package filemanagertocopy;
import java.io.File;                                                            
                                                                         
public class FileManagerToCopy{  
    
    public static void main(String[] args){                                     
        String dir_path = "";  //検索開始したいフォルダのPath(今回の場合なら`~Folder/`まで書く)
        String extension = ".wma";   //検索したいファイルの拡張子                      
        file_search(dir_path, extension);                                                  
    }                                                                           
    public static void file_search(String path, String extension){                                
        File dir = new File(path);                                              
        File files[] = dir.listFiles();                                         
        for(File file : files){                                      
            String file_name = file.getName();                              
            if(file.isDirectory()){  //ディレクトリなら再帰を行う                                                                        
                file_search(path+"/"+file_name, extension);                                
            }else{  
                if(file_name.endsWith(extension) 
                        && !file.getParent().equals(path)){  //file_nameの最後尾(拡張子)が指定のものならば出力                                 
                    
                    if(file.renameTo(new File(path + "\\"+ file_name))){
                        System.out.println(file.getPath() + "のコピーに成功");
                        file.delete();
                    }else{
                        System.out.println(file.getPath() + "のコピーに失敗しました。");
                    }
                }                                  
            }                                                                   
        }                                                                       
    }                                                                           
}          