package com.sun.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;

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
      new GitUtil().addCommitAndPush(filePath, message, username, password, localDir);
//      new GitUtil().updateFile(filePath, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateFile(String filePath, String username, String password) throws Exception {
    UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
    Git git = Git.open(new File(filePath));
    git.pull().setCredentialsProvider(provider).call();
    git.submoduleUpdate().call();
  }

  public void addCommitAndPush(String filePath, String message, String username, String password, String localDir) throws IOException, GitAPIException {
    UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
    Git git = Git.open(new File(filePath));
    git.add().addFilepattern(localDir).call();
    git.commit().setMessage(message).call();
    git.push().setCredentialsProvider(provider).call();
  }


  public void remoteClone(String username, String password, String remoteUrl, String localUrl) throws GitAPIException {
    UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
    Git.cloneRepository().setURI(remoteUrl).setCredentialsProvider(provider).setDirectory(new File(localUrl)).call();
  }


}
