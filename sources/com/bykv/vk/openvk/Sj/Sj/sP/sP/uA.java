package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class uA {

    /* renamed from: a, reason: collision with root package name */
    public final b f20356a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20357b;

    /* renamed from: c, reason: collision with root package name */
    public final a f20358c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class EjP extends Exception {
        EjP(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int f20359a;

        /* renamed from: b, reason: collision with root package name */
        final String f20360b;

        /* renamed from: c, reason: collision with root package name */
        final String f20361c;

        /* renamed from: d, reason: collision with root package name */
        final int f20362d;

        /* renamed from: e, reason: collision with root package name */
        final int f20363e;

        /* renamed from: f, reason: collision with root package name */
        final String f20364f;

        /* renamed from: g, reason: collision with root package name */
        final List f20365g;

        private a(int i11, String str, String str2, int i12, int i13, String str3, List list) {
            this.f20359a = i11;
            this.f20360b = str;
            this.f20361c = str2;
            this.f20362d = i12;
            this.f20363e = i13;
            this.f20364f = str3;
            this.f20365g = list;
        }

        static a a(b bVar, List list) {
            String str;
            int i11;
            int i12;
            int indexOf = bVar.f20367b.indexOf(UrlUtils.QUESTION_MARK);
            if (indexOf == -1) {
                throw new EjP("path format error, path: " + bVar.f20367b);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i13 = 0;
            for (String str5 : bVar.f20367b.substring(indexOf + 1).split(UrlUtils.AND_MARK)) {
                String[] split = str5.split(UrlUtils.EQUAL_MARK);
                if (split.length == 2) {
                    if ("rk".equals(split[0])) {
                        str3 = Uri.decode(split[1]);
                    } else if (CampaignEx.JSON_KEY_AD_K.equals(split[0])) {
                        str4 = Uri.decode(split[1]);
                    } else if (split[0].startsWith(TmcStartParams.KEY_URL_SHORT)) {
                        arrayList.add(Uri.decode(split[1]));
                    } else if ("f".equals(split[0]) && f6.a.t(split[1]) == 1) {
                        i13 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                throw new EjP("rawKey or key is empty, path: " + bVar.f20367b);
            }
            if (list != null) {
                Iterator it = list.iterator();
                i12 = 0;
                int i14 = 0;
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar != null && "Range".equalsIgnoreCase(cVar.f20369a)) {
                        int indexOf2 = cVar.f20370b.indexOf(UrlUtils.EQUAL_MARK);
                        if (indexOf2 == -1) {
                            throw new EjP("Range format error, Range: " + cVar.f20370b);
                        }
                        if (!"bytes".equalsIgnoreCase(cVar.f20370b.substring(0, indexOf2).trim())) {
                            throw new EjP("Range format error, Range: " + cVar.f20370b);
                        }
                        String substring = cVar.f20370b.substring(indexOf2 + 1);
                        if (substring.contains(",")) {
                            throw new EjP("Range format error, Range: " + cVar.f20370b);
                        }
                        int indexOf3 = substring.indexOf("-");
                        if (indexOf3 == -1) {
                            throw new EjP("Range format error, Range: " + cVar.f20370b);
                        }
                        String trim = substring.substring(0, indexOf3).trim();
                        String trim2 = substring.substring(indexOf3 + 1).trim();
                        try {
                            if (trim.length() > 0) {
                                i12 = Integer.parseInt(trim);
                            }
                            if (trim2.length() > 0 && i12 > (i14 = Integer.parseInt(trim2))) {
                                throw new EjP("Range format error, Range: " + cVar.f20370b);
                            }
                            str2 = cVar.f20370b;
                        } catch (NumberFormatException unused) {
                            throw new EjP("Range format error, Range: " + cVar.f20370b);
                        }
                    }
                }
                i11 = i14;
                str = str2;
            } else {
                str = null;
                i11 = 0;
                i12 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new a(i13, str3, str4, i12, i11, str, arrayList);
            }
            throw new EjP("no url found: path: " + bVar.f20367b);
        }

        public String toString() {
            return "Extra{flag=" + this.f20359a + ", rawKey='" + this.f20360b + "', key='" + this.f20361c + "', from=" + this.f20362d + ", to=" + this.f20363e + ", urls=" + this.f20365g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f20366a;

        /* renamed from: b, reason: collision with root package name */
        final String f20367b;

        /* renamed from: c, reason: collision with root package name */
        final String f20368c;

        private b(String str, String str2, String str3) {
            this.f20366a = str;
            this.f20367b = str2;
            this.f20368c = str3;
        }

        static b a(String str) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf <= indexOf) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
            String trim3 = str.substring(lastIndexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0 || trim3.length() == 0) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            return new b(trim, trim2, trim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.f20366a + "', path='" + this.f20367b + "', version='" + this.f20368c + "'}";
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f20369a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20370b;

        public c(String str, String str2) {
            this.f20369a = str;
            this.f20370b = str2;
        }

        static c a(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                throw new EjP("request header format error, header: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0) {
                throw new EjP("request header format error, header: ".concat(str));
            }
            return new c(trim, trim2);
        }

        public String toString() {
            return "Header{name='" + this.f20369a + "', value='" + this.f20370b + "'}";
        }
    }

    public uA(b bVar, List list, a aVar) {
        this.f20356a = bVar;
        this.f20357b = list;
        this.f20358c = aVar;
    }

    public static uA a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, f6.a.f62464b));
        ArrayList arrayList = new ArrayList();
        b bVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (bVar == null) {
                bVar = b.a(trim);
            } else {
                arrayList.add(c.a(trim));
            }
        }
        if (bVar != null) {
            return new uA(bVar, arrayList, a.a(bVar, arrayList));
        }
        throw new EjP("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.f20356a + ", headers=" + this.f20357b + ", extra=" + this.f20358c + '}';
    }
}
