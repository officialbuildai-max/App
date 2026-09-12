package j5;

import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.io.BufferedReader;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f66068a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f66069b = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.*)");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f66070c = Pattern.compile("(\\d+):(\\d+):(\\d+)[:\\.](\\d+)");

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final int a(String str) {
        Matcher matcher = f66070c.matcher(str);
        if (!matcher.matches()) {
            return 0;
        }
        String group = matcher.group(1);
        int parseInt = group != null ? Integer.parseInt(group) : 0;
        String group2 = matcher.group(2);
        int parseInt2 = group2 != null ? Integer.parseInt(group2) : 0;
        String group3 = matcher.group(3);
        int parseInt3 = group3 != null ? Integer.parseInt(group3) : 0;
        String group4 = matcher.group(4);
        return ((group4 != null ? Integer.parseInt(group4) : 0) * 10) + (parseInt3 * 1000) + (parseInt2 * 60000) + (parseInt * TimeConstants.HOUR);
    }

    private final void c(BufferedReader bufferedReader, String str, k5.d dVar) {
        k5.b bVar = new k5.b();
        while (str != null && str.length() != 0) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z10 = false;
            while (i11 <= length) {
                boolean z11 = Intrinsics.j(str.charAt(!z10 ? i11 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z11) {
                    i11++;
                } else {
                    z10 = true;
                }
            }
            Matcher matcher = f66069b.matcher(str.subSequence(i11, length + 1).toString());
            try {
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    long j11 = 23976;
                    long parseInt = ((group != null ? Integer.parseInt(group) : 0) * 1000000) / j11;
                    k5.c cVar = new k5.c("", "");
                    cVar.f66777a = (int) parseInt;
                    bVar.f66774b = cVar;
                    k5.c cVar2 = new k5.c("", "");
                    cVar2.f66777a = (int) (((matcher.group(2) != null ? Integer.parseInt(r3) : 0) * 1000000) / j11);
                    bVar.f66775c = cVar2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                if (matcher.matches()) {
                    bVar.f66776d = matcher.group(3);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            int i12 = bVar.f66774b.f66777a;
            while (dVar.f66786i.containsKey(Integer.valueOf(i12))) {
                i12++;
            }
            TreeMap treeMap = dVar.f66786i;
            Intrinsics.g(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i12), bVar);
            try {
                str = bufferedReader.readLine();
            } catch (Throwable unused) {
                str = "";
            }
            bVar = new k5.b();
        }
        dVar.f66790m = true;
    }

    private final void d(BufferedReader bufferedReader, String str, k5.d dVar) {
        k5.b bVar = new k5.b();
        while (str != null && !StringsKt.W(str, "[COLF]", false, 2, null)) {
            str = bufferedReader.readLine();
        }
        while (str != null && str.length() != 0) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                int length = readLine.length() - 1;
                int i11 = 0;
                boolean z10 = false;
                while (i11 <= length) {
                    boolean z11 = Intrinsics.j(readLine.charAt(!z10 ? i11 : length), 32) <= 0;
                    if (z10) {
                        if (!z11) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z11) {
                        i11++;
                    } else {
                        z10 = true;
                    }
                }
                str = readLine.subSequence(i11, length + 1).toString();
            } else {
                str = null;
            }
            if (str != null) {
                try {
                    List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, null);
                    if (S0 != null) {
                        String str2 = (String) S0.get(0);
                        String str3 = (String) S0.get(1);
                        int a11 = a(str2);
                        int a12 = a(str3);
                        k5.c cVar = new k5.c("", "");
                        cVar.f66777a = a11;
                        bVar.f66774b = cVar;
                        k5.c cVar2 = new k5.c("", "");
                        cVar2.f66777a = a12;
                        bVar.f66775c = cVar2;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    int length2 = readLine2.length() - 1;
                    int i12 = 0;
                    boolean z12 = false;
                    while (i12 <= length2) {
                        boolean z13 = Intrinsics.j(readLine2.charAt(!z12 ? i12 : length2), 32) <= 0;
                        if (z12) {
                            if (!z13) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z13) {
                            i12++;
                        } else {
                            z12 = true;
                        }
                    }
                    str = readLine2.subSequence(i12, length2 + 1).toString();
                } else {
                    str = null;
                }
                bVar.f66776d = str;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                bufferedReader.readLine();
            } catch (Throwable unused) {
            }
            int i13 = bVar.f66774b.f66777a;
            while (dVar.f66786i.containsKey(Integer.valueOf(i13))) {
                i13++;
            }
            TreeMap treeMap = dVar.f66786i;
            Intrinsics.g(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i13), bVar);
            bVar = new k5.b();
        }
        dVar.f66790m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (r12 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k5.d b(java.lang.String r10, java.lang.String r11, java.io.InputStream r12) {
        /*
            r9 = this;
            java.lang.String r0 = "unicode"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            k5.d r0 = new k5.d
            r0.<init>()
            int r1 = r11.length()
            if (r1 <= 0) goto L16
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r12, r11)
            goto L1b
        L16:
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r12)
        L1b:
            java.io.BufferedReader r11 = new java.io.BufferedReader
            r11.<init>(r1)
            r0.f66782e = r10
            java.lang.String r10 = r11.readLine()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r10 == 0) goto L61
            int r4 = r10.length()
            int r4 = r4 - r3
            r5 = r2
            r6 = r5
        L32:
            if (r5 > r4) goto L57
            if (r6 != 0) goto L38
            r7 = r5
            goto L39
        L38:
            r7 = r4
        L39:
            char r7 = r10.charAt(r7)
            r8 = 32
            int r7 = kotlin.jvm.internal.Intrinsics.j(r7, r8)
            if (r7 > 0) goto L47
            r7 = r3
            goto L48
        L47:
            r7 = r2
        L48:
            if (r6 != 0) goto L51
            if (r7 != 0) goto L4e
            r6 = r3
            goto L32
        L4e:
            int r5 = r5 + 1
            goto L32
        L51:
            if (r7 != 0) goto L54
            goto L57
        L54:
            int r4 = r4 + (-1)
            goto L32
        L57:
            int r4 = r4 + r3
            java.lang.CharSequence r10 = r10.subSequence(r5, r4)
            java.lang.String r10 = r10.toString()
            goto L62
        L61:
            r10 = r1
        L62:
            r4 = 2
            if (r10 == 0) goto L73
            java.lang.String r5 = "{"
            boolean r5 = kotlin.text.StringsKt.W(r10, r5, r2, r4, r1)     // Catch: java.lang.Throwable -> L71
            if (r5 != r3) goto L73
            r9.c(r11, r10, r0)     // Catch: java.lang.Throwable -> L71
            goto L91
        L71:
            r10 = move-exception
            goto L81
        L73:
            if (r10 == 0) goto L91
            java.lang.String r5 = "[INFORMATION]"
            boolean r1 = kotlin.text.StringsKt.W(r10, r5, r2, r4, r1)     // Catch: java.lang.Throwable -> L71
            if (r1 != r3) goto L91
            r9.d(r11, r10, r0)     // Catch: java.lang.Throwable -> L71
            goto L91
        L81:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L8a
            if (r12 == 0) goto L94
        L86:
            r12.close()
            goto L94
        L8a:
            r10 = move-exception
            if (r12 == 0) goto L90
            r12.close()
        L90:
            throw r10
        L91:
            if (r12 == 0) goto L94
            goto L86
        L94:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.d.b(java.lang.String, java.lang.String, java.io.InputStream):k5.d");
    }
}
