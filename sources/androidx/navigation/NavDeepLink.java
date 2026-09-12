package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class NavDeepLink {

    /* renamed from: l, reason: collision with root package name */
    private static final b f13890l = new b(null);

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f13891m = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a, reason: collision with root package name */
    private final String f13892a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13893b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13894c;

    /* renamed from: f, reason: collision with root package name */
    private String f13897f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13899h;

    /* renamed from: i, reason: collision with root package name */
    private String f13900i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13902k;

    /* renamed from: d, reason: collision with root package name */
    private final List f13895d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Map f13896e = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f13898g = LazyKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pattern$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.f13897f;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str, 2);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f13901j = LazyKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.f13900i;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str);
        }
    });

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final C0114a f13903d = new C0114a(null);

        /* renamed from: a, reason: collision with root package name */
        private String f13904a;

        /* renamed from: b, reason: collision with root package name */
        private String f13905b;

        /* renamed from: c, reason: collision with root package name */
        private String f13906c;

        /* renamed from: androidx.navigation.NavDeepLink$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0114a {
            private C0114a() {
            }

            public /* synthetic */ C0114a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f13904a, this.f13905b, this.f13906c);
        }

        public final a b(String action) {
            Intrinsics.h(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f13905b = action;
            return this;
        }

        public final a c(String mimeType) {
            Intrinsics.h(mimeType, "mimeType");
            this.f13906c = mimeType;
            return this;
        }

        public final a d(String uriPattern) {
            Intrinsics.h(uriPattern, "uriPattern");
            this.f13904a = uriPattern;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private String f13907a;

        /* renamed from: b, reason: collision with root package name */
        private String f13908b;

        public c(String mimeType) {
            List l11;
            Intrinsics.h(mimeType, "mimeType");
            List<String> split = new Regex("/").split(mimeType, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        l11 = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l11 = CollectionsKt.l();
            this.f13907a = (String) l11.get(0);
            this.f13908b = (String) l11.get(1);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c other) {
            Intrinsics.h(other, "other");
            int i11 = Intrinsics.c(this.f13907a, other.f13907a) ? 2 : 0;
            return Intrinsics.c(this.f13908b, other.f13908b) ? i11 + 1 : i11;
        }

        public final String b() {
            return this.f13908b;
        }

        public final String d() {
            return this.f13907a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private String f13909a;

        /* renamed from: b, reason: collision with root package name */
        private final List f13910b = new ArrayList();

        public final void a(String name) {
            Intrinsics.h(name, "name");
            this.f13910b.add(name);
        }

        public final String b(int i11) {
            return (String) this.f13910b.get(i11);
        }

        public final List c() {
            return this.f13910b;
        }

        public final String d() {
            return this.f13909a;
        }

        public final void e(String str) {
            this.f13909a = str;
        }

        public final int f() {
            return this.f13910b.size();
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.f13892a = str;
        this.f13893b = str2;
        this.f13894c = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.f13899h = parse.getQuery() != null;
            StringBuilder sb2 = new StringBuilder("^");
            if (!f13891m.matcher(str).find()) {
                sb2.append("http[s]?://");
            }
            Pattern fillInPattern = Pattern.compile("\\{(.+?)\\}");
            if (this.f13899h) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    String substring = str.substring(0, matcher.start());
                    Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.g(fillInPattern, "fillInPattern");
                    this.f13902k = c(substring, sb2, fillInPattern);
                }
                for (String paramName : parse.getQueryParameterNames()) {
                    StringBuilder sb3 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(paramName);
                    if (queryParameter == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Matcher matcher2 = fillInPattern.matcher(queryParameter);
                    d dVar = new d();
                    int i11 = 0;
                    while (matcher2.find()) {
                        String group = matcher2.group(1);
                        if (group == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        dVar.a(group);
                        String substring2 = queryParameter.substring(i11, matcher2.start());
                        Intrinsics.g(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb3.append(Pattern.quote(substring2));
                        sb3.append("(.+?)?");
                        i11 = matcher2.end();
                    }
                    if (i11 < queryParameter.length()) {
                        String substring3 = queryParameter.substring(i11);
                        Intrinsics.g(substring3, "this as java.lang.String).substring(startIndex)");
                        sb3.append(Pattern.quote(substring3));
                    }
                    String sb4 = sb3.toString();
                    Intrinsics.g(sb4, "argRegex.toString()");
                    dVar.e(StringsKt.Q(sb4, ".*", "\\E.*\\Q", false, 4, null));
                    Map map = this.f13896e;
                    Intrinsics.g(paramName, "paramName");
                    map.put(paramName, dVar);
                }
            } else {
                Intrinsics.g(fillInPattern, "fillInPattern");
                this.f13902k = c(str, sb2, fillInPattern);
            }
            String sb5 = sb2.toString();
            Intrinsics.g(sb5, "uriRegex.toString()");
            this.f13897f = StringsKt.Q(sb5, ".*", "\\E.*\\Q", false, 4, null);
        }
        if (this.f13894c != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.f13894c).matches()) {
                throw new IllegalArgumentException(("The given mimeType " + ((Object) g()) + " does not match to required \"type/subtype\" format").toString());
            }
            c cVar = new c(this.f13894c);
            this.f13900i = StringsKt.Q("^(" + cVar.d() + "|[*]+)/(" + cVar.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
        }
    }

    private final boolean c(String str, StringBuilder sb2, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z10 = !StringsKt.c0(str, ".*", false, 2, null);
        int i11 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f13895d.add(group);
            String substring = str.substring(i11, matcher.start());
            Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(Pattern.quote(substring));
            sb2.append("([^/]+?)");
            i11 = matcher.end();
            z10 = false;
        }
        if (i11 < str.length()) {
            String substring2 = str.substring(i11);
            Intrinsics.g(substring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(Pattern.quote(substring2));
        }
        sb2.append("($|(\\?(.)*)|(\\#(.)*))");
        return z10;
    }

    private final Pattern i() {
        return (Pattern) this.f13901j.getValue();
    }

    private final Pattern j() {
        return (Pattern) this.f13898g.getValue();
    }

    private final boolean m(Bundle bundle, String str, String str2, androidx.navigation.d dVar) {
        if (dVar != null) {
            dVar.a().d(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    public final String d() {
        return this.f13893b;
    }

    public final List e() {
        List list = this.f13895d;
        Collection values = this.f13896e.values();
        ArrayList arrayList = new ArrayList();
        Iterator it = values.iterator();
        while (it.hasNext()) {
            CollectionsKt.B(arrayList, ((d) it.next()).c());
        }
        return CollectionsKt.B0(list, arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        return Intrinsics.c(this.f13892a, navDeepLink.f13892a) && Intrinsics.c(this.f13893b, navDeepLink.f13893b) && Intrinsics.c(this.f13894c, navDeepLink.f13894c);
    }

    public final Bundle f(Uri deepLink, Map arguments) {
        Matcher matcher;
        String str;
        Intrinsics.h(deepLink, "deepLink");
        Intrinsics.h(arguments, "arguments");
        Pattern j11 = j();
        Matcher matcher2 = j11 == null ? null : j11.matcher(deepLink.toString());
        if (matcher2 == null || !matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f13895d.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            String str2 = (String) this.f13895d.get(i11);
            String value = Uri.decode(matcher2.group(i12));
            androidx.navigation.d dVar = (androidx.navigation.d) arguments.get(str2);
            try {
                Intrinsics.g(value, "value");
                if (m(bundle, str2, value, dVar)) {
                    return null;
                }
                i11 = i12;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (this.f13899h) {
            for (String str3 : this.f13896e.keySet()) {
                d dVar2 = (d) this.f13896e.get(str3);
                String queryParameter = deepLink.getQueryParameter(str3);
                if (queryParameter != null) {
                    Intrinsics.e(dVar2);
                    matcher = Pattern.compile(dVar2.d(), 32).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                Bundle bundle2 = new Bundle();
                try {
                    Intrinsics.e(dVar2);
                    int f11 = dVar2.f();
                    int i13 = 0;
                    while (i13 < f11) {
                        int i14 = i13 + 1;
                        if (matcher != null) {
                            str = matcher.group(i14);
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = null;
                        }
                        String b11 = dVar2.b(i13);
                        androidx.navigation.d dVar3 = (androidx.navigation.d) arguments.get(b11);
                        if (str != null) {
                            if (!Intrinsics.c(str, '{' + b11 + '}') && m(bundle2, b11, str, dVar3)) {
                                return null;
                            }
                        }
                        i13 = i14;
                    }
                    bundle.putAll(bundle2);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        for (Map.Entry entry : arguments.entrySet()) {
            String str4 = (String) entry.getKey();
            androidx.navigation.d dVar4 = (androidx.navigation.d) entry.getValue();
            if (dVar4 != null && !dVar4.c() && !dVar4.b() && !bundle.containsKey(str4)) {
                return null;
            }
        }
        return bundle;
    }

    public final String g() {
        return this.f13894c;
    }

    public final int h(String mimeType) {
        Intrinsics.h(mimeType, "mimeType");
        if (this.f13894c != null) {
            Pattern i11 = i();
            Intrinsics.e(i11);
            if (i11.matcher(mimeType).matches()) {
                return new c(this.f13894c).compareTo(new c(mimeType));
            }
        }
        return -1;
    }

    public int hashCode() {
        String str = this.f13892a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f13893b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f13894c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String k() {
        return this.f13892a;
    }

    public final boolean l() {
        return this.f13902k;
    }
}
