
package filemanagertocopy;
import java.io.File;                                                            
                                                                         
public class FileManagerToCopy{  
    
    public static void main(String[] args){                                     
        
        //移動開始したいフォルダのPath
        String dir_path = "";
        
        //移動したいファイルの拡張子
        String extension = ".wma";

        file_search(dir_path, extension);                                                  
    }   
    
    /*
    * ファイル移動
    *@param 移動開始したいフォルダのPath
    *@Param 移動したいファイルの拡張子
    */
    public static void file_search(String path, String extension){                                
        File dir = new File(path);                                              
        File files[] = dir.listFiles();                                         
        for(File file : files){                                      
            String file_name = file.getName();                              
            if(file.isDirectory()){  //ディレクトリなら再帰を行う                                                                        
                file_search(path+"/"+file_name, extension);                                
            }else{  

                // 拡張子が一致している かつ 移動先フォルダに存在しないファイル
                if(file_name.endsWith(extension) 
                        && !file.getParent().equals(path)){                                 
                    
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