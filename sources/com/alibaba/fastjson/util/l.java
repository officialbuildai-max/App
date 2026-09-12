package com.alibaba.fastjson.util;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f18347a = new HashSet();

    public static Set a(Class cls, ClassLoader classLoader) {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String str = "META-INF/services/" + cls.getName();
        HashSet hashSet2 = new HashSet();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Set set = f18347a;
                if (!set.contains(nextElement.toString())) {
                    b(nextElement, hashSet2);
                    set.add(nextElement.toString());
                }
            }
        } catch (Throwable unused) {
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(classLoader.loadClass((String) it.next()).newInstance());
            } catch (Exception unused2) {
            }
        }
        return hashSet;
    }

    public static void b(URL url, Set set) {
        InputStream inputStream;
        BufferedReader bufferedReader = null;
        try {
            inputStream = FirebasePerfUrlConnection.openStream(url);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            f.a(bufferedReader2);
                            f.a(inputStream);
                            return;
                        }
                        int indexOf = readLine.indexOf(35);
                        if (indexOf >= 0) {
                            readLine = readLine.substring(0, indexOf);
                        }
                        String trim = readLine.trim();
                        if (trim.length() != 0) {
                            set.add(trim);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        f.a(bufferedReader);
                        f.a(inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }
}
