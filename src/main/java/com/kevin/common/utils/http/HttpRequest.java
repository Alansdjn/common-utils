package com.kevin.common.utils.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpRequest {

    /**
     * ��ָ��URL����GET����������
     * 
     * @param url ���������URL
     * @param param ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return URL ������Զ����Դ����Ӧ���
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // �򿪺�URL֮�������
            URLConnection connection = realUrl.openConnection();
            // ����ͨ�õ���������
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����ʵ�ʵ�����
            connection.connect();
            // ��ȡ������Ӧͷ�ֶ�
            // Map<String, List<String>> map = connection.getHeaderFields();
            // �������е���Ӧͷ�ֶ�
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ��ָ�� URL ����POST����������
     * 
     * @param url ��������� URL
     * @param param ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ������Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر��������������
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String getWordsFromFile(String filePath) {
        String words = "";
        BufferedReader br = null;
        try {
            File filename = new File(filePath);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            br = new BufferedReader(reader);
            String lineWords = br.readLine();
            while (lineWords != null) {
                words += lineWords + ";";
                lineWords = br.readLine(); // һ�ζ���һ������
            }
            return words;
        } catch (Exception e) {
            return words;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {

                }
            }
        }
    }

    /**
     * Get XML String of utf-8
     * 
     * @return XML-Formed string
     */
    public static String getUTF8XMLString(String xml) {
        // A StringBuffer Object
        StringBuffer sb = new StringBuffer();
        sb.append(xml);
        String xmString = "";
        String xmlUTF8 = "";
        try {
            xmString = new String(sb.toString().getBytes("UTF-8"));
            xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
            // System.out.println("utf-8 ���룺" + xmlUTF8);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // return to String Formed
        return xmlUTF8;
    }

    public static boolean writeTxtFile(String content, File fileName) throws Exception {
        RandomAccessFile mm = null;
        boolean flag = false;
        FileOutputStream o = null;
        try {
            o = new FileOutputStream(fileName);
            o.write(content.getBytes("GBK"));
            o.close();
            flag = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (mm != null) {
                mm.close();
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        String words = HttpRequest.getWordsFromFile("C:/Users/kevin.ww/Desktop/xinhua-result-2.txt");
        String[] wordArr = words.split(";");
//        char[] charArray = words.toCharArray();
        int index = 0;
        int total = wordArr.length;
        String result = "";
        for (String word : wordArr) {
            index++;
//            Thread.sleep(500);
            String[] wordAndStrokeCount = word.split(":");
            if (wordAndStrokeCount.length < 2) {
                result += word + "\n";
                continue;
            }
            int strokeCountInFile = Integer.parseInt(wordAndStrokeCount[1]);
            if (strokeCountInFile != -1) {
                result += word + "\n";
                continue;
            }
            System.out.print("(" + index + " / " + total + ") ");
            System.out.print(wordAndStrokeCount[0] + " : ");
            result += wordAndStrokeCount[0] + ":";
            
            
            String s = HttpRequest.sendGet("http://hanyu.baidu.com/zici/s", "wd=" + wordAndStrokeCount[0]);
            System.out.println(s);
//            String s = HttpRequest.sendPost("http://bihua.xpcha.com", "q=" + new String(charArray, index++, 1));
            int beginIndex = s.indexOf("stroke_count");
            if (beginIndex < 0) {
                System.out.println("-1");
                result += "-1" + "\n";
                continue;
            }
            String subString = s.substring(beginIndex);
            beginIndex = subString.indexOf("<span>") + 6;
            int endIndex = subString.indexOf("</span>");
            if (endIndex <= beginIndex) {
                System.out.println("-1");
                result += "-1" + "\n";
                continue;
            }
            String strokeCountStr = subString.substring(beginIndex, endIndex);

            try {
                Integer.parseInt(strokeCountStr);
                result += strokeCountStr + "\n";
                System.out.println(strokeCountStr);
            } catch (Exception e) {
                System.out.println("-1");
                result += "-1" + "\n";
            }
        }

        HttpRequest.writeTxtFile(result, new File("C:/Users/kevin.ww/Desktop/xinhua-result-3.txt"));
        // ���� POST ����
        // String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        // System.out.println(sr);
    }
}
