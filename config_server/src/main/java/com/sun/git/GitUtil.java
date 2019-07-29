package com.sun.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-26
 * @since 0.0.1
 **/
public class GitUtil {

  public static void main(String[] args) {
    String remoteUrl = "http://suntaozhang@192.168.101.30:10101/r/~admin/config.git";
    String localUrl = "E:\\你怕是失了智";
    String username = "suntaozhang";
    String password = "123456";

    String branch = "master";
    String filePath = "E:\\你怕是失了智\\.git";
    //添加目录，可以把目录下的文件都添加到暂存区
    String localDir = ".";
    String message = "失了智";
    try {
//      new GitUtil().remoteClone(username, password, remoteUrl, localUrl);
      new GitUtil().commitAndPush(filePath, message, username, password, localDir);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public void remoteClone(String username, String password, String remoteUrl, String localUrl) throws GitAPIException {
    UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
    Git.cloneRepository().setURI(remoteUrl).setCredentialsProvider(provider).setDirectory(new File(localUrl)).call();
  }


  public void commitAndPush(String filePath, String message, String username, String password, String localDir) throws IOException, GitAPIException {
    UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
    Git git = Git.open(new File(filePath));
    git.add().addFilepattern(localDir).call();
    git.commit().setMessage(message).call();
    git.push().setCredentialsProvider(provider).call();
  }

}
