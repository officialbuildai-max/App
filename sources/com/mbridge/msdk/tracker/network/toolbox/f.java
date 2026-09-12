package com.mbridge.msdk.tracker.network.toolbox;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.c0;
import com.mbridge.msdk.tracker.network.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* loaded from: classes5.dex */
public class f {
    public static b.a a(q qVar) {
        boolean z10;
        long j11;
        long j12;
        long j13;
        long j14;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = qVar.f38671c;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        long b11 = str != null ? b(str) : 0L;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i11 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z10 = false;
            j11 = 0;
            j12 = 0;
            while (i11 < split.length) {
                String trim = split[i11].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i11++;
            }
            i11 = 1;
        } else {
            z10 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long b12 = str3 != null ? b(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long b13 = str4 != null ? b(str4) : 0L;
        String str5 = map.get("ETag");
        if (i11 != 0) {
            j14 = currentTimeMillis + (j11 * 1000);
            if (!z10) {
                Long.signum(j12);
                j13 = j14;
                j14 += j12 * 1000;
                b.a aVar = new b.a();
                aVar.f38606a = qVar.f38670b;
                aVar.f38607b = str5;
                aVar.f38611f = j13;
                aVar.f38610e = j14;
                aVar.f38608c = b11;
                aVar.f38609d = b13;
                aVar.f38612g = map;
                aVar.f38613h = qVar.f38672d;
                return aVar;
            }
            j13 = j14;
            b.a aVar2 = new b.a();
            aVar2.f38606a = qVar.f38670b;
            aVar2.f38607b = str5;
            aVar2.f38611f = j13;
            aVar2.f38610e = j14;
            aVar2.f38608c = b11;
            aVar2.f38609d = b13;
            aVar2.f38612g = map;
            aVar2.f38613h = qVar.f38672d;
            return aVar2;
        }
        j13 = 0;
        if (b11 <= 0 || b12 < b11) {
            j14 = 0;
            b.a aVar22 = new b.a();
            aVar22.f38606a = qVar.f38670b;
            aVar22.f38607b = str5;
            aVar22.f38611f = j13;
            aVar22.f38610e = j14;
            aVar22.f38608c = b11;
            aVar22.f38609d = b13;
            aVar22.f38612g = map;
            aVar22.f38613h = qVar.f38672d;
            return aVar22;
        }
        j14 = currentTimeMillis + (b12 - b11);
        j13 = j14;
        b.a aVar222 = new b.a();
        aVar222.f38606a = qVar.f38670b;
        aVar222.f38607b = str5;
        aVar222.f38611f = j13;
        aVar222.f38610e = j14;
        aVar222.f38608c = b11;
        aVar222.f38609d = b13;
        aVar222.f38612g = map;
        aVar222.f38613h = qVar.f38672d;
        return aVar222;
    }

    static String a(long j11) {
        return a("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j11));
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get(HttpHeaders.CONTENT_TYPE)) != null) {
            String[] split = str2.split(";", 0);
            for (int i11 = 1; i11 < split.length; i11++) {
                String[] split2 = split[i11].trim().split(UrlUtils.EQUAL_MARK, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    private static SimpleDateFormat a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.mbridge.msdk.tracker.network.g> a(List<com.mbridge.msdk.tracker.network.g> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.mbridge.msdk.tracker.network.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.mbridge.msdk.tracker.network.g> list2 = aVar.f38613h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.mbridge.msdk.tracker.network.g gVar : aVar.f38613h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.f38612g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f38612g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> a(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f38607b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j11 = aVar.f38609d;
        if (j11 > 0) {
            hashMap.put("If-Modified-Since", a(j11));
        }
        return hashMap;
    }

    public static long b(String str) {
        try {
            Date parse = a("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e11) {
            if ("0".equals(str) || TmcConstants.COLD_OPEN_TYPE.equals(str)) {
                c0.d("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                c0.a(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0L;
        }
    }
}
