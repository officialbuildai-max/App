package com.bytedance.sdk.component.sP.Sj;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class Jcg {
    private static final char[] EjP = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> Dq;
    private final String HiB;
    private final List<String> Jcg;
    final String Sj;
    private final String TEQ;
    final int TKC;
    final String sP;
    private final String uA;
    private final String vS;

    /* loaded from: classes2.dex */
    public static final class Sj {
        String Dq;
        String EjP;
        List<String> Jcg;
        String Sj;
        final List<String> vS;
        String sP = "";
        String TKC = "";
        int HiB = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.component.sP.Sj.Jcg$Sj$Sj, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0233Sj {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Sj() {
            ArrayList arrayList = new ArrayList();
            this.vS = arrayList;
            arrayList.add("");
        }

        private static int EjP(String str, int i11, int i12) {
            while (i11 < i12) {
                char charAt = str.charAt(i11);
                if (charAt == ':') {
                    return i11;
                }
                if (charAt != '[') {
                    i11++;
                }
                do {
                    i11++;
                    if (i11 < i12) {
                    }
                    i11++;
                } while (str.charAt(i11) != ']');
                i11++;
            }
            return i12;
        }

        private static String HiB(String str, int i11, int i12) {
            return com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(Jcg.Sj(str, i11, i12, false));
        }

        private boolean HiB(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private Sj Sj(String str, boolean z10) {
            int i11 = 0;
            do {
                int Sj = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, i11, str.length(), "/\\");
                Sj(str, i11, Sj, Sj < str.length(), z10);
                i11 = Sj + 1;
            } while (i11 <= str.length());
            return this;
        }

        private void Sj(String str, int i11, int i12) {
            if (i11 == i12) {
                return;
            }
            char charAt = str.charAt(i11);
            if (charAt == '/' || charAt == '\\') {
                this.vS.clear();
                this.vS.add("");
                i11++;
            } else {
                List<String> list = this.vS;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i13 = i11;
                if (i13 >= i12) {
                    return;
                }
                i11 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, i13, i12, "/\\");
                boolean z10 = i11 < i12;
                Sj(str, i13, i11, z10, true);
                if (z10) {
                    i11++;
                }
            }
        }

        private void Sj(String str, int i11, int i12, boolean z10, boolean z11) {
            String Sj = Jcg.Sj(str, i11, i12, HttpUrl.PATH_SEGMENT_ENCODE_SET, z11, false, false, true, null);
            if (HiB(Sj)) {
                return;
            }
            if (vS(Sj)) {
                TKC();
                return;
            }
            if (this.vS.get(r11.size() - 1).isEmpty()) {
                this.vS.set(r11.size() - 1, Sj);
            } else {
                this.vS.add(Sj);
            }
            if (z10) {
                this.vS.add("");
            }
        }

        private static int TKC(String str, int i11, int i12) {
            int i13 = 0;
            while (i11 < i12) {
                char charAt = str.charAt(i11);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i13++;
                i11++;
            }
            return i13;
        }

        private void TKC() {
            if (!this.vS.remove(r0.size() - 1).isEmpty() || this.vS.isEmpty()) {
                this.vS.add("");
            } else {
                this.vS.set(r0.size() - 1, "");
            }
        }

        private static int sP(String str, int i11, int i12) {
            if (i12 - i11 < 2) {
                return -1;
            }
            char charAt = str.charAt(i11);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i11++;
                    if (i11 >= i12) {
                        break;
                    }
                    char charAt2 = str.charAt(i11);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i11;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int vS(String str, int i11, int i12) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(Jcg.Sj(str, i11, i12, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private boolean vS(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public Sj EjP(String str) {
            this.Jcg = str != null ? Jcg.sP(Jcg.Sj(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        int Sj() {
            int i11 = this.HiB;
            return i11 != -1 ? i11 : Jcg.Sj(this.Sj);
        }

        EnumC0233Sj Sj(Jcg jcg, String str) {
            int Sj;
            int i11;
            int Sj2 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, 0, str.length());
            int sP = com.bytedance.sdk.component.sP.Sj.sP.uA.sP(str, Sj2, str.length());
            if (sP(str, Sj2, sP) != -1) {
                if (str.regionMatches(true, Sj2, "https:", 0, 6)) {
                    this.Sj = "https";
                    Sj2 += 6;
                } else {
                    if (!str.regionMatches(true, Sj2, "http:", 0, 5)) {
                        return EnumC0233Sj.UNSUPPORTED_SCHEME;
                    }
                    this.Sj = "http";
                    Sj2 += 5;
                }
            } else {
                if (jcg == null) {
                    return EnumC0233Sj.MISSING_SCHEME;
                }
                this.Sj = jcg.Sj;
            }
            int TKC = TKC(str, Sj2, sP);
            char c11 = '?';
            char c12 = '#';
            if (TKC >= 2 || jcg == null || !jcg.Sj.equals(this.Sj)) {
                boolean z10 = false;
                boolean z11 = false;
                int i12 = Sj2 + TKC;
                while (true) {
                    Sj = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, i12, sP, "@/\\?#");
                    char charAt = Sj != sP ? str.charAt(Sj) : (char) 65535;
                    if (charAt == 65535 || charAt == c12 || charAt == '/' || charAt == '\\' || charAt == c11) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z10) {
                            i11 = Sj;
                            this.TKC += "%40" + Jcg.Sj(str, i12, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int Sj3 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, i12, Sj, ':');
                            i11 = Sj;
                            String Sj4 = Jcg.Sj(str, i12, Sj3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                Sj4 = this.sP + "%40" + Sj4;
                            }
                            this.sP = Sj4;
                            if (Sj3 != i11) {
                                this.TKC = Jcg.Sj(str, Sj3 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        }
                        i12 = i11 + 1;
                        c11 = '?';
                        c12 = '#';
                    }
                }
                int EjP = EjP(str, i12, Sj);
                int i13 = EjP + 1;
                if (i13 < Sj) {
                    this.EjP = HiB(str, i12, EjP);
                    int vS = vS(str, i13, Sj);
                    this.HiB = vS;
                    if (vS == -1) {
                        return EnumC0233Sj.INVALID_PORT;
                    }
                } else {
                    this.EjP = HiB(str, i12, EjP);
                    this.HiB = Jcg.Sj(this.Sj);
                }
                if (this.EjP == null) {
                    return EnumC0233Sj.INVALID_HOST;
                }
                Sj2 = Sj;
            } else {
                this.sP = jcg.sP();
                this.TKC = jcg.TKC();
                this.EjP = jcg.sP;
                this.HiB = jcg.TKC;
                this.vS.clear();
                this.vS.addAll(jcg.EjP());
                if (Sj2 == sP || str.charAt(Sj2) == '#') {
                    EjP(jcg.HiB());
                }
            }
            int Sj5 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, Sj2, sP, "?#");
            Sj(str, Sj2, Sj5);
            if (Sj5 < sP && str.charAt(Sj5) == '?') {
                int Sj6 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, Sj5, sP, '#');
                this.Jcg = Jcg.sP(Jcg.Sj(str, Sj5 + 1, Sj6, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                Sj5 = Sj6;
            }
            if (Sj5 < sP && str.charAt(Sj5) == '#') {
                this.Dq = Jcg.Sj(str, 1 + Sj5, sP, "", true, false, false, false, null);
            }
            return EnumC0233Sj.SUCCESS;
        }

        public Sj Sj(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.Sj = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: ".concat(str));
                }
                this.Sj = "https";
            }
            return this;
        }

        public Sj Sj(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.Jcg == null) {
                this.Jcg = new ArrayList();
            }
            this.Jcg.add(Jcg.Sj(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.Jcg.add(str2 != null ? Jcg.Sj(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public Sj TKC(String str) {
            if (str != null) {
                return Sj(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Sj sP(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String HiB = HiB(str, 0, str.length());
            if (HiB == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.EjP = HiB;
            return this;
        }

        public Jcg sP() {
            if (this.Sj == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.EjP != null) {
                return new Jcg(this);
            }
            throw new IllegalStateException("host == null");
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.Sj);
            sb2.append("://");
            if (!this.sP.isEmpty() || !this.TKC.isEmpty()) {
                sb2.append(this.sP);
                if (!this.TKC.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.TKC);
                }
                sb2.append('@');
            }
            if (this.EjP.indexOf(58) != -1) {
                sb2.append('[');
                sb2.append(this.EjP);
                sb2.append(']');
            } else {
                sb2.append(this.EjP);
            }
            int Sj = Sj();
            if (Sj != Jcg.Sj(this.Sj)) {
                sb2.append(':');
                sb2.append(Sj);
            }
            Jcg.Sj(sb2, this.vS);
            if (this.Jcg != null) {
                sb2.append('?');
                Jcg.sP(sb2, this.Jcg);
            }
            if (this.Dq != null) {
                sb2.append('#');
                sb2.append(this.Dq);
            }
            return sb2.toString();
        }
    }

    Jcg(Sj sj2) {
        this.Sj = sj2.Sj;
        this.HiB = Sj(sj2.sP, false);
        this.vS = Sj(sj2.TKC, false);
        this.sP = sj2.EjP;
        this.TKC = sj2.Sj();
        this.Jcg = Sj(sj2.vS, false);
        List<String> list = sj2.Jcg;
        this.Dq = list != null ? Sj(list, true) : null;
        String str = sj2.Dq;
        this.uA = str != null ? Sj(str, false) : null;
        this.TEQ = sj2.toString();
    }

    public static int Sj(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String Sj(String str, int i11, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int i13 = i11;
        while (i13 < i12) {
            int codePointAt = str.codePointAt(i13);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z13)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z10 && (!z11 || Sj(str, i13, i12)))) && (codePointAt != 43 || !z12))) {
                    i13 += Character.charCount(codePointAt);
                }
            }
            com.bytedance.sdk.component.sP.Sj.sP.Sj sj2 = new com.bytedance.sdk.component.sP.Sj.sP.Sj();
            sj2.Sj(str, i11, i13);
            Sj(sj2, str, i13, i12, str2, z10, z11, z12, z13, charset);
            return sj2.TKC();
        }
        return str.substring(i11, i12);
    }

    static String Sj(String str, int i11, int i12, boolean z10) {
        for (int i13 = i11; i13 < i12; i13++) {
            char charAt = str.charAt(i13);
            if (charAt == '%' || (charAt == '+' && z10)) {
                com.bytedance.sdk.component.sP.Sj.sP.Sj sj2 = new com.bytedance.sdk.component.sP.Sj.sP.Sj();
                sj2.Sj(str, i11, i13);
                Sj(sj2, str, i13, i12, z10);
                return sj2.TKC();
            }
        }
        return str.substring(i11, i12);
    }

    static String Sj(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return Sj(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    static String Sj(String str, boolean z10) {
        return Sj(str, 0, str.length(), z10);
    }

    private List<String> Sj(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            String str = list.get(i11);
            arrayList.add(str != null ? Sj(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void Sj(com.bytedance.sdk.component.sP.Sj.sP.Sj sj2, String str, int i11, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        com.bytedance.sdk.component.sP.Sj.sP.Sj sj3 = null;
        while (i11 < i12) {
            int codePointAt = str.codePointAt(i11);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z12) {
                    sj2.Sj(z10 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z13) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z10 || (z11 && !Sj(str, i11, i12)))))) {
                    if (sj3 == null) {
                        sj3 = new com.bytedance.sdk.component.sP.Sj.sP.Sj();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.sP.Sj.sP.uA.Sj)) {
                        sj3.Sj(codePointAt);
                    } else {
                        sj3.Sj(str, i11, Character.charCount(codePointAt) + i11, charset);
                    }
                    while (!sj3.Sj()) {
                        byte sP = sj3.sP();
                        sj2.sP(37);
                        char[] cArr = EjP;
                        sj2.sP((int) cArr[((sP & 255) >> 4) & 15]);
                        sj2.sP((int) cArr[sP & 15]);
                    }
                } else {
                    sj2.Sj(codePointAt);
                }
            }
            i11 += Character.charCount(codePointAt);
        }
    }

    static void Sj(com.bytedance.sdk.component.sP.Sj.sP.Sj sj2, String str, int i11, int i12, boolean z10) {
        int i13;
        while (i11 < i12) {
            int codePointAt = str.codePointAt(i11);
            if (codePointAt != 37 || (i13 = i11 + 2) >= i12) {
                if (codePointAt == 43 && z10) {
                    sj2.sP(32);
                }
                sj2.Sj(codePointAt);
            } else {
                int Sj2 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str.charAt(i11 + 1));
                int Sj3 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str.charAt(i13));
                if (Sj2 != -1 && Sj3 != -1) {
                    sj2.sP((Sj2 << 4) + Sj3);
                    i11 = i13;
                }
                sj2.Sj(codePointAt);
            }
            i11 += Character.charCount(codePointAt);
        }
    }

    static void Sj(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append('/');
            sb2.append(list.get(i11));
        }
    }

    static boolean Sj(String str, int i11, int i12) {
        int i13 = i11 + 2;
        return i13 < i12 && str.charAt(i11) == '%' && com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str.charAt(i11 + 1)) != -1 && com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str.charAt(i13)) != -1;
    }

    public static Jcg TKC(String str) {
        Sj sj2 = new Sj();
        if (sj2.Sj((Jcg) null, str) == Sj.EnumC0233Sj.SUCCESS) {
            return sj2.sP();
        }
        return null;
    }

    static List<String> sP(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 <= str.length()) {
            int indexOf = str.indexOf(38, i11);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i11);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i11, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i11, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i11 = indexOf + 1;
        }
        return arrayList;
    }

    static void sP(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            String str = list.get(i11);
            String str2 = list.get(i11 + 1);
            if (i11 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    public List<String> EjP() {
        int indexOf = this.TEQ.indexOf(47, this.Sj.length() + 3);
        String str = this.TEQ;
        int Sj2 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < Sj2) {
            int i11 = indexOf + 1;
            int Sj3 = com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(this.TEQ, i11, Sj2, '/');
            arrayList.add(this.TEQ.substring(i11, Sj3));
            indexOf = Sj3;
        }
        return arrayList;
    }

    public String HiB() {
        if (this.Dq == null) {
            return null;
        }
        int indexOf = this.TEQ.indexOf(63) + 1;
        String str = this.TEQ;
        return this.TEQ.substring(indexOf, com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, indexOf, str.length(), '#'));
    }

    public URL Sj() {
        try {
            return new URL(this.TEQ);
        } catch (MalformedURLException e11) {
            throw new RuntimeException(e11);
        }
    }

    public String TKC() {
        if (this.vS.isEmpty()) {
            return "";
        }
        return this.TEQ.substring(this.TEQ.indexOf(58, this.Sj.length() + 3) + 1, this.TEQ.indexOf(64));
    }

    public boolean equals(Object obj) {
        return (obj instanceof Jcg) && ((Jcg) obj).TEQ.equals(this.TEQ);
    }

    public int hashCode() {
        return this.TEQ.hashCode();
    }

    public String sP() {
        if (this.HiB.isEmpty()) {
            return "";
        }
        int length = this.Sj.length() + 3;
        String str = this.TEQ;
        return this.TEQ.substring(length, com.bytedance.sdk.component.sP.Sj.sP.uA.Sj(str, length, str.length(), ":@"));
    }

    public String toString() {
        return this.TEQ;
    }
}
