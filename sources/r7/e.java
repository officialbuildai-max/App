package r7;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class e implements r7.d, r7.c {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f74293c = Pattern.compile("\\{([^{}]*)\\}");

    /* renamed from: a, reason: collision with root package name */
    private String f74294a;

    /* renamed from: b, reason: collision with root package name */
    private List f74295b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends d {

        /* renamed from: c, reason: collision with root package name */
        String f74296c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadLocal f74297d;

        /* renamed from: r7.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0929a extends ThreadLocal {
            C0929a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat(a.this.f74296c, Locale.US);
            }
        }

        a(String str, String str2, String str3) {
            super(str, str2);
            C0929a c0929a = new C0929a();
            this.f74297d = c0929a;
            this.f74296c = str3;
            try {
                ((SimpleDateFormat) c0929a.get()).format(new Date());
            } catch (Exception e11) {
                throw new IllegalArgumentException("Bad date pattern: " + str3, e11);
            }
        }

        @Override // r7.e.d
        protected String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f74300a, ((SimpleDateFormat) this.f74297d.get()).format(new Date(j11)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b extends d {

        /* renamed from: c, reason: collision with root package name */
        boolean f74299c;

        b(String str, String str2, boolean z10) {
            super(str, str2);
            this.f74299c = z10;
        }

        @Override // r7.e.d
        protected String a(String str, long j11, int i11, String str2, String str3) {
            return this.f74299c ? str.replace(this.f74300a, q7.c.a(i11)) : str.replace(this.f74300a, q7.c.b(i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class c extends d {
        c(String str, String str2) {
            super(str, str2);
        }

        @Override // r7.e.d
        protected String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f74300a, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        String f74300a;

        /* renamed from: b, reason: collision with root package name */
        String f74301b;

        d(String str, String str2) {
            this.f74300a = str;
            this.f74301b = str2;
        }

        protected abstract String a(String str, long j11, int i11, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r7.e$e, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0930e extends d {
        C0930e(String str, String str2) {
            super(str, str2);
        }

        @Override // r7.e.d
        protected String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f74300a, str2);
        }
    }

    public e(String str) {
        if (str == null) {
            throw new NullPointerException("Pattern should not be null");
        }
        this.f74294a = str;
        List g11 = g(h(str));
        this.f74295b = g11;
        if (g11.size() != 0) {
            return;
        }
        throw new IllegalArgumentException("No recognizable parameter found in the pattern " + str);
    }

    static a c(String str, String str2) {
        if (str2.startsWith("d ") && str2.length() > 2) {
            return new a(str, str2, str2.substring(2));
        }
        if (str2.equals("d")) {
            return new a(str, str2, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }

    static b d(String str, String str2) {
        if (str2.equals("l")) {
            return new b(str, str2, false);
        }
        if (str2.equals("L")) {
            return new b(str, str2, true);
        }
        return null;
    }

    static c e(String str, String str2) {
        if (str2.equals("m")) {
            return new c(str, str2);
        }
        return null;
    }

    private static d f(String str) {
        String str2 = "{" + str + "}";
        String trim = str.trim();
        a c11 = c(str2, trim);
        if (c11 != null) {
            return c11;
        }
        b d11 = d(str2, trim);
        if (d11 != null) {
            return d11;
        }
        C0930e i11 = i(str2, trim);
        if (i11 != null) {
            return i11;
        }
        c e11 = e(str2, trim);
        if (e11 != null) {
            return e11;
        }
        return null;
    }

    private static List g(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d f11 = f((String) it.next());
            if (f11 != null) {
                arrayList.add(f11);
            }
        }
        return arrayList;
    }

    static List h(String str) {
        ArrayList arrayList = new ArrayList(4);
        Matcher matcher = f74293c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    static C0930e i(String str, String str2) {
        if (str2.equals("t")) {
            return new C0930e(str, str2);
        }
        return null;
    }

    @Override // r7.c
    public CharSequence a(long j11, int i11, String str, String str2) {
        String str3 = this.f74294a;
        Iterator it = this.f74295b.iterator();
        String str4 = str3;
        while (it.hasNext()) {
            str4 = ((d) it.next()).a(str4, j11, i11, str, str2);
        }
        return str4;
    }

    @Override // r7.d
    public CharSequence b(int i11, String str, String str2) {
        return a(System.currentTimeMillis(), i11, str, str2);
    }
}
