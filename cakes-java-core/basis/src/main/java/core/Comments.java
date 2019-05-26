package core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 注释
 *
 * @author haoc
 */
public class Comments {

  public static void main(String[] args) throws FileNotFoundException {
    int i = 0;  // 就是定义个变量而已,尾注释有啥的

	// 我靠,我这段信息可是很重要啊
    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File("/etc/profile")));   
  }

}
