package com.amazonaws.handlers;

import android.support.v4.media.session.c;
import com.amazonaws.AmazonClientException;
import com.amazonaws.util.ClassLoaderHelper;
import com.amazonaws.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HandlerChainFactory {
    private List a(String str, Class cls) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                InputStream resourceAsStream = getClass().getResourceAsStream(str);
                if (resourceAsStream == null) {
                    return arrayList;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(resourceAsStream, StringUtils.f19086a));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused) {
                            }
                            return arrayList;
                        }
                        String trim = readLine.trim();
                        if (!"".equals(trim)) {
                            Object newInstance = ClassLoaderHelper.loadClass(trim, cls, getClass()).newInstance();
                            if (!cls.isInstance(newInstance)) {
                                throw new AmazonClientException("Unable to instantiate request handler chain for client.  Listed request handler ('" + trim + "') does not implement the " + cls + " API.");
                            }
                            if (cls == RequestHandler2.class) {
                                arrayList.add((RequestHandler2) newInstance);
                            } else {
                                if (cls != RequestHandler.class) {
                                    throw new IllegalStateException();
                                }
                                c.a(newInstance);
                                arrayList.add(RequestHandler2.a(null));
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        bufferedReader = bufferedReader2;
                        throw new AmazonClientException("Unable to instantiate request handler chain for client: " + e.getMessage(), e);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public List b(String str) {
        return a(str, RequestHandler2.class);
    }

    public List c(String str) {
        return a(str, RequestHandler.class);
    }
}
