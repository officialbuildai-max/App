package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class JsonUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final AwsJsonFactory f19109a = new GsonFactory();

    @Deprecated
    /* loaded from: classes2.dex */
    public enum JsonEngine {
        Gson,
        Jackson
    }

    public static AwsJsonReader a(Reader reader) {
        return f19109a.b(reader);
    }

    public static AwsJsonWriter b(Writer writer) {
        return f19109a.a(writer);
    }

    public static Map c(Reader reader) {
        AwsJsonReader a11 = a(reader);
        try {
            if (a11.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            a11.a();
            while (a11.hasNext()) {
                String e11 = a11.e();
                if (a11.d()) {
                    a11.c();
                } else {
                    hashMap.put(e11, a11.f());
                }
            }
            a11.b();
            a11.close();
            return Collections.unmodifiableMap(hashMap);
        } catch (IOException e12) {
            throw new AmazonClientException("Unable to parse JSON String.", e12);
        }
    }

    public static Map d(String str) {
        return (str == null || str.isEmpty()) ? Collections.EMPTY_MAP : c(new StringReader(str));
    }

    public static String e(Map map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter b11 = b(stringWriter);
            b11.a();
            for (Map.Entry entry : map.entrySet()) {
                b11.c((String) entry.getKey()).d((String) entry.getValue());
            }
            b11.b();
            b11.close();
            return stringWriter.toString();
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e11);
        }
    }
}
