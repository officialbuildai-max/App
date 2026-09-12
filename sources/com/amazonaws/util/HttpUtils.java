package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class HttpUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f19076a = Pattern.compile(Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote("%7E") + "|" + Pattern.quote("%2F"));

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f19077b;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Pattern.quote("%2A"));
        sb2.append("|");
        sb2.append(Pattern.quote("%2B"));
        sb2.append("|");
        f19077b = Pattern.compile(sb2.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2, false);
    }

    public static String b(String str, String str2, boolean z10) {
        if (str2 == null || str2.length() <= 0) {
            if (str.endsWith("/")) {
                return str;
            }
            return str + "/";
        }
        if (str2.startsWith("/")) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        String e11 = e(str2, true);
        if (z10) {
            e11 = e11.replace("//", "/%2F");
        }
        return str + e11;
    }

    public static String c(Request request) {
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            boolean z10 = true;
            for (Map.Entry entry : request.getParameters().entrySet()) {
                String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                String str = (String) entry.getValue();
                String encode2 = str == null ? "" : URLEncoder.encode(str, "UTF-8");
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(UrlUtils.AND_MARK);
                }
                sb2.append(encode);
                sb2.append(UrlUtils.EQUAL_MARK);
                sb2.append(encode2);
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static boolean d(URI uri) {
        String b11 = StringUtils.b(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if ("http".equals(b11) && port == 80) {
            return false;
        }
        return ("https".equals(b11) && port == 443) ? false : true;
    }

    public static String e(String str, boolean z10) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = f19076a.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = "%20";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = "~";
                } else if (z10 && "%2F".equals(group)) {
                    group = "/";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static boolean f(Request request) {
        return HttpMethodName.POST.equals(request.m()) && (request.getContent() == null);
    }
}
