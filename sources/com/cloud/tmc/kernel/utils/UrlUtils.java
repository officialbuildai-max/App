package com.cloud.tmc.kernel.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.func.MimeTypeKt;
import com.cloud.tmc.miniutils.util.EncodeUtils;
import com.transsion.gslb.Utils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class UrlUtils {
    public static final String AND_MARK = "&";
    public static final String EQUAL_MARK = "=";
    public static final String QUESTION_MARK = "?";
    public static final String TAG = "TmcKernel:UrlUtils";
    private static LruCache<String, Uri> sCachedUriMap = new LruCache<>(20);
    private static LruCache<String, String> sCachedPurifyUrlMap = new LruCache<>(20);

    public static String addParam(String str, String str2, String str3) {
        return addParam(str, str2, str3, true);
    }

    public static String addParam(String str, String str2, String str3, boolean z10) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        if (StringUtils.isEmpty(str2)) {
            return str.trim();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str2.trim(), str3);
        return addParams(str, linkedHashMap, z10);
    }

    public static String addParamNotExist(String str, String str2, String str3) {
        return addParam(str, str2, str3, false);
    }

    public static String addParams(String str, Map<String, String> map) {
        return addParams(str, map, true);
    }

    public static String addParams(String str, Map<String, String> map, boolean z10) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        if (map == null || map.size() < 1) {
            return str.trim();
        }
        Uri parseUrl = parseUrl(str);
        if (parseUrl == null) {
            return "";
        }
        Uri.Builder buildUpon = parseUrl.buildUpon();
        buildUpon.clearQuery();
        Map paramsMap = getParamsMap(str);
        if (paramsMap == null) {
            paramsMap = new LinkedHashMap();
        }
        if (!z10) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!StringUtils.isEmpty(entry.getKey())) {
                    linkedHashMap.put(entry.getKey().trim(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                for (Map.Entry entry3 : paramsMap.entrySet()) {
                    if (!StringUtils.isEmpty((CharSequence) entry2.getKey()) && ((String) entry2.getKey()).trim().equals(entry3.getKey())) {
                        map.remove(((String) entry2.getKey()).trim());
                    }
                }
            }
        }
        for (Map.Entry<String, String> entry4 : map.entrySet()) {
            paramsMap.put(entry4.getKey().trim(), entry4.getValue());
        }
        if (paramsMap.size() > 0) {
            for (String str2 : paramsMap.keySet()) {
                String str3 = (String) paramsMap.get(str2);
                if (str3 == null) {
                    str3 = "";
                }
                buildUpon.appendQueryParameter(str2, str3);
            }
        }
        return buildUpon.build().toString();
    }

    public static String addParamsNotExist(String str, Map<String, String> map) {
        return addParams(str, map, false);
    }

    @Nullable
    public static String decode(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e11) {
            TmcLogger.e(TAG, "Exception", e11);
            return null;
        }
    }

    @Nullable
    public static String encode(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            TmcLogger.e(TAG, "Exception", e11);
            return null;
        }
    }

    public static String getCORSUrl(String str) {
        try {
            Uri parseUrl = parseUrl(str);
            if (parseUrl == null) {
                return "";
            }
            String str2 = parseUrl.getScheme() + "://" + parseUrl.getHost();
            if (parseUrl.getPort() == -1) {
                return str2;
            }
            return str2 + ":" + parseUrl.getPort();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getContentTypeFromUrl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String extension = getExtension(str);
            if (extension == null) {
                extension = "";
            }
            return MimeTypeKt.getMimeType(extension, false);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
            return null;
        }
    }

    public static String getExtension(String str) {
        String path;
        String str2;
        int lastIndexOf;
        try {
            if (!TextUtils.isEmpty(str) && (path = Uri.parse(str).getPath()) != null) {
                String[] split = path.split("/");
                if (split.length > 0 && (lastIndexOf = (str2 = split[split.length - 1]).lastIndexOf(46)) != -1) {
                    return str2.substring(lastIndexOf + 1);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
        }
        return null;
    }

    public static String getHash(String str) {
        int indexOf;
        Uri parseUrl = parseUrl(str);
        String fragment = parseUrl != null ? parseUrl.getFragment() : null;
        if (fragment != null && (indexOf = fragment.indexOf(QUESTION_MARK)) > 0) {
            fragment = fragment.substring(0, indexOf);
        }
        return (fragment == null || !fragment.startsWith("/")) ? fragment : fragment.substring(1);
    }

    public static String getHost(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getHost();
        }
        return null;
    }

    public static String getOnlineHost(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("file:///") || str.startsWith("data:")) {
            return null;
        }
        return getHost(str);
    }

    public static String getParam(Uri uri, String str, String str2) {
        String str3;
        if (uri == null) {
            return str2;
        }
        try {
            str3 = uri.getQueryParameter(str);
        } catch (Exception e11) {
            TmcLogger.e(TAG, "Exception", e11);
            str3 = null;
        }
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    @Nullable
    public static Map<String, String> getParamsMap(String str) {
        String query;
        try {
        } catch (Exception e11) {
            TmcLogger.e(TAG, "getParamsMap failed", e11);
        }
        if (!StringUtils.isEmpty(str) && (query = getQuery(str)) != null && !StringUtils.isEmpty(query)) {
            String[] split = query.split(AND_MARK);
            if (split.length > 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str2 : split) {
                    if (!StringUtils.isEmpty(str2)) {
                        String[] split2 = str2.split(EQUAL_MARK);
                        if (split2.length > 0) {
                            String str3 = split2[0];
                            if (!StringUtils.isEmpty(str3)) {
                                if (split2.length > 1) {
                                    linkedHashMap.put(str3.trim(), split2[1]);
                                } else {
                                    linkedHashMap.put(str3.trim(), "");
                                }
                            }
                        }
                    }
                }
                return linkedHashMap;
            }
            return null;
        }
        return null;
    }

    public static String getPath(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getPath();
        }
        return null;
    }

    public static String getPathAndHash(String str) {
        return getPath(str) + Utils.SEPARATOR + getHash(str);
    }

    public static int getPort(String str) {
        try {
            Uri parseUrl = parseUrl(str);
            if (parseUrl == null || parseUrl.getPort() == -1) {
                return -1;
            }
            return parseUrl.getPort();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getQuery(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getQuery();
        }
        return null;
    }

    public static String getScheme(String str) {
        Uri parseUrl = parseUrl(str);
        if (parseUrl != null) {
            return parseUrl.getScheme();
        }
        return null;
    }

    public static boolean isUrlInDomainArray(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        Uri parseUrl = parseUrl(str);
        if (parseUrl == null) {
            TmcLogger.d(TAG, "parse auto url failed!");
            return false;
        }
        String host = parseUrl.getHost();
        if (TextUtils.isEmpty(host)) {
            TmcLogger.d(TAG, "can't get url host");
            return false;
        }
        String lowerCase = host.toLowerCase();
        try {
            for (String str2 : strArr) {
                if (!str2.equalsIgnoreCase(lowerCase)) {
                    if (!lowerCase.endsWith("." + str2)) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e11) {
            TmcLogger.e(TAG, "match auto login exception.", e11);
            return false;
        }
    }

    public static String mergeUrl(String str, String str2) {
        String purifyUrl;
        int lastIndexOf;
        Uri parseUrl = parseUrl(str2);
        if (parseUrl == null || !TextUtils.isEmpty(parseUrl.getScheme())) {
            return str2;
        }
        String str3 = null;
        if (str2.startsWith("//")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parseUrl2 = parseUrl(str);
            if (parseUrl2 != null && !TextUtils.isEmpty(parseUrl2.getScheme())) {
                str3 = parseUrl2.getScheme() + ":" + str2;
            }
            TmcLogger.d(TAG, "getAbsoluteUrl // " + str3);
            return str3;
        }
        if (!str2.startsWith("/")) {
            if (TextUtils.isEmpty(str2) || (lastIndexOf = (purifyUrl = purifyUrl(str)).lastIndexOf("/")) == -1) {
                return null;
            }
            String str4 = purifyUrl.substring(0, lastIndexOf) + "/" + str2;
            TmcLogger.d(TAG, "getAbsoluteUrl else " + str4);
            return str4;
        }
        Uri parseUrl3 = parseUrl(str);
        if (parseUrl3 == null) {
            return null;
        }
        String scheme = parseUrl3.getScheme();
        String authority = parseUrl3.getAuthority();
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority)) {
            str3 = scheme + "://" + authority + str2;
        }
        TmcLogger.d(TAG, "getAbsoluteUrl / " + str3);
        return str3;
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = sCachedUriMap.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            sCachedUriMap.put(str, uri);
            return uri;
        } catch (Exception e11) {
            TmcLogger.e(TAG, "parse url exception.", e11);
            return uri;
        }
    }

    public static String purifyUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str3 = sCachedPurifyUrlMap.get(str);
        if (str3 != null) {
            return str3;
        }
        try {
            int indexOf = str.indexOf(Utils.SEPARATOR);
            str2 = indexOf != -1 ? str.substring(0, indexOf) : str;
        } catch (Throwable unused) {
            str2 = str;
        }
        try {
            if (str2.contains("??")) {
                sCachedPurifyUrlMap.put(str, str2);
                return str2;
            }
            int indexOf2 = str2.indexOf(QUESTION_MARK);
            if (indexOf2 != -1) {
                str2 = str2.substring(0, indexOf2);
            }
            sCachedPurifyUrlMap.put(str, str2);
            return str2;
        } catch (Throwable unused2) {
            sCachedPurifyUrlMap.put(str, str2);
            return str2;
        }
    }

    public static String removeParams(String str, String... strArr) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        if (strArr == null || strArr.length < 1) {
            return str.trim();
        }
        Uri parseUrl = parseUrl(str);
        if (parseUrl == null) {
            return "";
        }
        Uri.Builder buildUpon = parseUrl.buildUpon();
        buildUpon.clearQuery();
        Map<String, String> paramsMap = getParamsMap(str);
        if (paramsMap != null && paramsMap.size() > 0) {
            for (String str2 : strArr) {
                if (!StringUtils.isEmpty(str2)) {
                    paramsMap.remove(str2.trim());
                }
            }
        }
        if (paramsMap == null || paramsMap.size() <= 0) {
            return str;
        }
        for (String str3 : paramsMap.keySet()) {
            buildUpon.appendQueryParameter(str3, paramsMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    public static String stripAnchor(String str) {
        int indexOf = str.indexOf(35);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf);
        TmcLogger.d(TAG, "stripAnchor url:" + str + " afterUrl:" + substring);
        return substring;
    }

    public static String urlDecode(String str) {
        return EncodeUtils.urlDecode(str);
    }
}
