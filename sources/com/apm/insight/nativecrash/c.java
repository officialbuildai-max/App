package com.apm.insight.nativecrash;

import com.apm.insight.l.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f19802i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f19803j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f19804k = Pattern.compile("^Abort message: (.*)$");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f19805l = Pattern.compile("^Crash message: (.*)$");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f19806m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* renamed from: a, reason: collision with root package name */
    private String f19807a;

    /* renamed from: b, reason: collision with root package name */
    private String f19808b;

    /* renamed from: c, reason: collision with root package name */
    private String f19809c;

    /* renamed from: d, reason: collision with root package name */
    private String f19810d;

    /* renamed from: e, reason: collision with root package name */
    private String f19811e;

    /* renamed from: f, reason: collision with root package name */
    private String f19812f;

    /* renamed from: g, reason: collision with root package name */
    private String f19813g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f19814h = new HashMap();

    public c(File file) {
        c(j.b(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x018a, code lost:
    
        r12 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018e, code lost:
    
        if (r12 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0196, code lost:
    
        if (r12.contains("BuildId:") == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0198, code lost:
    
        r12 = com.apm.insight.nativecrash.c.f19806m.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a2, code lost:
    
        if (r12.find() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a4, code lost:
    
        r0 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b6, code lost:
    
        if (r0.equals("data") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b8, code lost:
    
        r11.f19814h.put(r1, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.io.File r12) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.c.c(java.io.File):void");
    }

    public final String a() {
        return this.f19813g;
    }

    public final void a(File file) {
        File b11 = j.b(file);
        if (b11.exists()) {
            b11.renameTo(new File(b11.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        c(j.b(file));
    }

    public final Map<String, String> b() {
        return this.f19814h;
    }

    public final void b(File file) {
        c(j.b(file));
    }

    public final String c() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f19811e;
        if (str != null) {
            sb2.append(str);
        }
        String str2 = this.f19812f;
        if (str2 != null) {
            sb2.append(str2);
        }
        String str3 = this.f19813g;
        if (str3 != null) {
            sb2.append(str3);
        }
        return sb2.toString();
    }
}
