package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.a0;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    private final Class f74533a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f74534b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpUrl f74535c;

    /* renamed from: d, reason: collision with root package name */
    final String f74536d;

    /* renamed from: e, reason: collision with root package name */
    private final String f74537e;

    /* renamed from: f, reason: collision with root package name */
    private final Headers f74538f;

    /* renamed from: g, reason: collision with root package name */
    private final MediaType f74539g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f74540h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f74541i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f74542j;

    /* renamed from: k, reason: collision with root package name */
    private final a0[] f74543k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f74544l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: y, reason: collision with root package name */
        private static final Pattern f74545y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: z, reason: collision with root package name */
        private static final Pattern f74546z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        final k0 f74547a;

        /* renamed from: b, reason: collision with root package name */
        final Class f74548b;

        /* renamed from: c, reason: collision with root package name */
        final Method f74549c;

        /* renamed from: d, reason: collision with root package name */
        final Annotation[] f74550d;

        /* renamed from: e, reason: collision with root package name */
        final Annotation[][] f74551e;

        /* renamed from: f, reason: collision with root package name */
        final Type[] f74552f;

        /* renamed from: g, reason: collision with root package name */
        boolean f74553g;

        /* renamed from: h, reason: collision with root package name */
        boolean f74554h;

        /* renamed from: i, reason: collision with root package name */
        boolean f74555i;

        /* renamed from: j, reason: collision with root package name */
        boolean f74556j;

        /* renamed from: k, reason: collision with root package name */
        boolean f74557k;

        /* renamed from: l, reason: collision with root package name */
        boolean f74558l;

        /* renamed from: m, reason: collision with root package name */
        boolean f74559m;

        /* renamed from: n, reason: collision with root package name */
        boolean f74560n;

        /* renamed from: o, reason: collision with root package name */
        String f74561o;

        /* renamed from: p, reason: collision with root package name */
        boolean f74562p;

        /* renamed from: q, reason: collision with root package name */
        boolean f74563q;

        /* renamed from: r, reason: collision with root package name */
        boolean f74564r;

        /* renamed from: s, reason: collision with root package name */
        String f74565s;

        /* renamed from: t, reason: collision with root package name */
        Headers f74566t;

        /* renamed from: u, reason: collision with root package name */
        MediaType f74567u;

        /* renamed from: v, reason: collision with root package name */
        Set f74568v;

        /* renamed from: w, reason: collision with root package name */
        a0[] f74569w;

        /* renamed from: x, reason: collision with root package name */
        boolean f74570x;

        a(k0 k0Var, Class cls, Method method) {
            this.f74547a = k0Var;
            this.f74548b = cls;
            this.f74549c = method;
            this.f74550d = method.getAnnotations();
            this.f74552f = method.getGenericParameterTypes();
            this.f74551e = method.getParameterAnnotations();
        }

        private static Class a(Class cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr, boolean z10) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw o0.n(this.f74549c, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.f74567u = MediaType.get(trim);
                    } catch (IllegalArgumentException e11) {
                        throw o0.o(this.f74549c, e11, "Malformed content type: %s", trim);
                    }
                } else if (z10) {
                    builder.addUnsafeNonAscii(substring, trim);
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z10) {
            String str3 = this.f74561o;
            if (str3 != null) {
                throw o0.n(this.f74549c, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f74561o = str;
            this.f74562p = z10;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (f74545y.matcher(substring).find()) {
                    throw o0.n(this.f74549c, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.f74565s = str2;
            this.f74568v = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof DELETE) {
                d("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                d("GET", ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                d("HEAD", ((HEAD) annotation).value(), false);
                return;
            }
            if (annotation instanceof PATCH) {
                d("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                d("POST", ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                d("PUT", ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                d("OPTIONS", ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                d(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                retrofit2.http.Headers headers = (retrofit2.http.Headers) annotation;
                String[] value = headers.value();
                if (value.length == 0) {
                    throw o0.n(this.f74549c, "@Headers annotation is empty.", new Object[0]);
                }
                this.f74566t = c(value, headers.allowUnsafeNonAsciiValues());
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.f74563q) {
                    throw o0.n(this.f74549c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f74564r = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.f74564r) {
                    throw o0.n(this.f74549c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f74563q = true;
            }
        }

        private a0 f(int i11, Type type, Annotation[] annotationArr, boolean z10) {
            a0 a0Var;
            if (annotationArr != null) {
                a0Var = null;
                for (Annotation annotation : annotationArr) {
                    a0 g11 = g(i11, type, annotationArr, annotation);
                    if (g11 != null) {
                        if (a0Var != null) {
                            throw o0.p(this.f74549c, i11, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        a0Var = g11;
                    }
                }
            } else {
                a0Var = null;
            }
            if (a0Var != null) {
                return a0Var;
            }
            if (z10) {
                try {
                    if (o0.h(type) == Continuation.class) {
                        this.f74570x = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw o0.p(this.f74549c, i11, "No Retrofit annotation found.", new Object[0]);
        }

        private a0 g(int i11, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                j(i11, type);
                if (this.f74560n) {
                    throw o0.p(this.f74549c, i11, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f74556j) {
                    throw o0.p(this.f74549c, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f74557k) {
                    throw o0.p(this.f74549c, i11, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f74558l) {
                    throw o0.p(this.f74549c, i11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f74559m) {
                    throw o0.p(this.f74549c, i11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f74565s != null) {
                    throw o0.p(this.f74549c, i11, "@Url cannot be used with @%s URL", this.f74561o);
                }
                this.f74560n = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new a0.p(this.f74549c, i11);
                }
                throw o0.p(this.f74549c, i11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                j(i11, type);
                if (this.f74557k) {
                    throw o0.p(this.f74549c, i11, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f74558l) {
                    throw o0.p(this.f74549c, i11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f74559m) {
                    throw o0.p(this.f74549c, i11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f74560n) {
                    throw o0.p(this.f74549c, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f74565s == null) {
                    throw o0.p(this.f74549c, i11, "@Path can only be used with relative url on @%s", this.f74561o);
                }
                this.f74556j = true;
                Path path = (Path) annotation;
                String value = path.value();
                i(i11, value);
                return new a0.k(this.f74549c, i11, value, this.f74547a.i(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                j(i11, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class h11 = o0.h(type);
                this.f74557k = true;
                if (!Iterable.class.isAssignableFrom(h11)) {
                    return h11.isArray() ? new a0.l(value2, this.f74547a.i(a(h11.getComponentType()), annotationArr), encoded).b() : new a0.l(value2, this.f74547a.i(type, annotationArr), encoded);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.l(value2, this.f74547a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                }
                throw o0.p(this.f74549c, i11, h11.getSimpleName() + " must include generic type (e.g., " + h11.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                j(i11, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class h12 = o0.h(type);
                this.f74558l = true;
                if (!Iterable.class.isAssignableFrom(h12)) {
                    return h12.isArray() ? new a0.n(this.f74547a.i(a(h12.getComponentType()), annotationArr), encoded2).b() : new a0.n(this.f74547a.i(type, annotationArr), encoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.n(this.f74547a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                }
                throw o0.p(this.f74549c, i11, h12.getSimpleName() + " must include generic type (e.g., " + h12.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                j(i11, type);
                Class h13 = o0.h(type);
                this.f74559m = true;
                if (!Map.class.isAssignableFrom(h13)) {
                    throw o0.p(this.f74549c, i11, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type i12 = o0.i(type, h13, Map.class);
                if (!(i12 instanceof ParameterizedType)) {
                    throw o0.p(this.f74549c, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) i12;
                Type g11 = o0.g(0, parameterizedType);
                if (String.class == g11) {
                    return new a0.m(this.f74549c, i11, this.f74547a.i(o0.g(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw o0.p(this.f74549c, i11, "@QueryMap keys must be of type String: " + g11, new Object[0]);
            }
            if (annotation instanceof Header) {
                j(i11, type);
                Header header = (Header) annotation;
                String value3 = header.value();
                Class h14 = o0.h(type);
                if (!Iterable.class.isAssignableFrom(h14)) {
                    return h14.isArray() ? new a0.f(value3, this.f74547a.i(a(h14.getComponentType()), annotationArr), header.allowUnsafeNonAsciiValues()).b() : new a0.f(value3, this.f74547a.i(type, annotationArr), header.allowUnsafeNonAsciiValues());
                }
                if (type instanceof ParameterizedType) {
                    return new a0.f(value3, this.f74547a.i(o0.g(0, (ParameterizedType) type), annotationArr), header.allowUnsafeNonAsciiValues()).c();
                }
                throw o0.p(this.f74549c, i11, h14.getSimpleName() + " must include generic type (e.g., " + h14.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new a0.h(this.f74549c, i11);
                }
                j(i11, type);
                Class h15 = o0.h(type);
                if (!Map.class.isAssignableFrom(h15)) {
                    throw o0.p(this.f74549c, i11, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                }
                Type i13 = o0.i(type, h15, Map.class);
                if (!(i13 instanceof ParameterizedType)) {
                    throw o0.p(this.f74549c, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) i13;
                Type g12 = o0.g(0, parameterizedType2);
                if (String.class == g12) {
                    return new a0.g(this.f74549c, i11, this.f74547a.i(o0.g(1, parameterizedType2), annotationArr), ((HeaderMap) annotation).allowUnsafeNonAsciiValues());
                }
                throw o0.p(this.f74549c, i11, "@HeaderMap keys must be of type String: " + g12, new Object[0]);
            }
            if (annotation instanceof Field) {
                j(i11, type);
                if (!this.f74563q) {
                    throw o0.p(this.f74549c, i11, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.f74553g = true;
                Class h16 = o0.h(type);
                if (!Iterable.class.isAssignableFrom(h16)) {
                    return h16.isArray() ? new a0.d(value4, this.f74547a.i(a(h16.getComponentType()), annotationArr), encoded3).b() : new a0.d(value4, this.f74547a.i(type, annotationArr), encoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.d(value4, this.f74547a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                }
                throw o0.p(this.f74549c, i11, h16.getSimpleName() + " must include generic type (e.g., " + h16.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                j(i11, type);
                if (!this.f74563q) {
                    throw o0.p(this.f74549c, i11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class h17 = o0.h(type);
                if (!Map.class.isAssignableFrom(h17)) {
                    throw o0.p(this.f74549c, i11, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type i14 = o0.i(type, h17, Map.class);
                if (!(i14 instanceof ParameterizedType)) {
                    throw o0.p(this.f74549c, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) i14;
                Type g13 = o0.g(0, parameterizedType3);
                if (String.class == g13) {
                    k i15 = this.f74547a.i(o0.g(1, parameterizedType3), annotationArr);
                    this.f74553g = true;
                    return new a0.e(this.f74549c, i11, i15, ((FieldMap) annotation).encoded());
                }
                throw o0.p(this.f74549c, i11, "@FieldMap keys must be of type String: " + g13, new Object[0]);
            }
            if (annotation instanceof Part) {
                j(i11, type);
                if (!this.f74564r) {
                    throw o0.p(this.f74549c, i11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.f74554h = true;
                String value5 = part.value();
                Class h18 = o0.h(type);
                if (value5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(h18)) {
                        if (h18.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h18.getComponentType())) {
                                return a0.o.f74505a.b();
                            }
                            throw o0.p(this.f74549c, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(h18)) {
                            return a0.o.f74505a;
                        }
                        throw o0.p(this.f74549c, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (MultipartBody.Part.class.isAssignableFrom(o0.h(o0.g(0, (ParameterizedType) type)))) {
                            return a0.o.f74505a.c();
                        }
                        throw o0.p(this.f74549c, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw o0.p(this.f74549c, i11, h18.getSimpleName() + " must include generic type (e.g., " + h18.getSimpleName() + "<String>)", new Object[0]);
                }
                Headers of2 = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
                if (!Iterable.class.isAssignableFrom(h18)) {
                    if (!h18.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(h18)) {
                            throw o0.p(this.f74549c, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new a0.i(this.f74549c, i11, of2, this.f74547a.g(type, annotationArr, this.f74550d));
                    }
                    Class a11 = a(h18.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(a11)) {
                        throw o0.p(this.f74549c, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new a0.i(this.f74549c, i11, of2, this.f74547a.g(a11, annotationArr, this.f74550d)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type g14 = o0.g(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(o0.h(g14))) {
                        throw o0.p(this.f74549c, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new a0.i(this.f74549c, i11, of2, this.f74547a.g(g14, annotationArr, this.f74550d)).c();
                }
                throw o0.p(this.f74549c, i11, h18.getSimpleName() + " must include generic type (e.g., " + h18.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof PartMap) {
                j(i11, type);
                if (!this.f74564r) {
                    throw o0.p(this.f74549c, i11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f74554h = true;
                Class h19 = o0.h(type);
                if (!Map.class.isAssignableFrom(h19)) {
                    throw o0.p(this.f74549c, i11, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type i16 = o0.i(type, h19, Map.class);
                if (!(i16 instanceof ParameterizedType)) {
                    throw o0.p(this.f74549c, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) i16;
                Type g15 = o0.g(0, parameterizedType4);
                if (String.class == g15) {
                    Type g16 = o0.g(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(o0.h(g16))) {
                        throw o0.p(this.f74549c, i11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new a0.j(this.f74549c, i11, this.f74547a.g(g16, annotationArr, this.f74550d), ((PartMap) annotation).encoding());
                }
                throw o0.p(this.f74549c, i11, "@PartMap keys must be of type String: " + g15, new Object[0]);
            }
            if (annotation instanceof Body) {
                j(i11, type);
                if (this.f74563q || this.f74564r) {
                    throw o0.p(this.f74549c, i11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f74555i) {
                    throw o0.p(this.f74549c, i11, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    k g17 = this.f74547a.g(type, annotationArr, this.f74550d);
                    this.f74555i = true;
                    return new a0.c(this.f74549c, i11, g17);
                } catch (RuntimeException e11) {
                    throw o0.q(this.f74549c, e11, i11, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof Tag)) {
                return null;
            }
            j(i11, type);
            Class h20 = o0.h(type);
            for (int i17 = i11 - 1; i17 >= 0; i17--) {
                a0 a0Var = this.f74569w[i17];
                if ((a0Var instanceof a0.q) && ((a0.q) a0Var).f74508a.equals(h20)) {
                    throw o0.p(this.f74549c, i11, "@Tag type " + h20.getName() + " is duplicate of " + b0.f74516b.a(this.f74549c, i17) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new a0.q(h20);
        }

        static Set h(String str) {
            Matcher matcher = f74545y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i11, String str) {
            if (!f74546z.matcher(str).matches()) {
                throw o0.p(this.f74549c, i11, "@Path parameter name must match %s. Found: %s", f74545y.pattern(), str);
            }
            if (!this.f74568v.contains(str)) {
                throw o0.p(this.f74549c, i11, "URL \"%s\" does not contain \"{%s}\".", this.f74565s, str);
            }
        }

        private void j(int i11, Type type) {
            if (o0.j(type)) {
                throw o0.p(this.f74549c, i11, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        i0 b() {
            for (Annotation annotation : this.f74550d) {
                e(annotation);
            }
            if (this.f74561o == null) {
                throw o0.n(this.f74549c, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f74562p) {
                if (this.f74564r) {
                    throw o0.n(this.f74549c, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f74563q) {
                    throw o0.n(this.f74549c, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f74551e.length;
            this.f74569w = new a0[length];
            int i11 = length - 1;
            int i12 = 0;
            while (i12 < length) {
                this.f74569w[i12] = f(i12, this.f74552f[i12], this.f74551e[i12], i12 == i11);
                i12++;
            }
            if (this.f74565s == null && !this.f74560n) {
                throw o0.n(this.f74549c, "Missing either @%s URL or @Url parameter.", this.f74561o);
            }
            boolean z10 = this.f74563q;
            if (!z10 && !this.f74564r && !this.f74562p && this.f74555i) {
                throw o0.n(this.f74549c, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z10 && !this.f74553g) {
                throw o0.n(this.f74549c, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f74564r || this.f74554h) {
                return new i0(this);
            }
            throw o0.n(this.f74549c, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    i0(a aVar) {
        this.f74533a = aVar.f74548b;
        this.f74534b = aVar.f74549c;
        this.f74535c = aVar.f74547a.f74583c;
        this.f74536d = aVar.f74561o;
        this.f74537e = aVar.f74565s;
        this.f74538f = aVar.f74566t;
        this.f74539g = aVar.f74567u;
        this.f74540h = aVar.f74562p;
        this.f74541i = aVar.f74563q;
        this.f74542j = aVar.f74564r;
        this.f74543k = aVar.f74569w;
        this.f74544l = aVar.f74570x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i0 b(k0 k0Var, Class cls, Method method) {
        return new a(k0Var, cls, method).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request a(Object obj, Object[] objArr) {
        a0[] a0VarArr = this.f74543k;
        int length = objArr.length;
        if (length != a0VarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + a0VarArr.length + ")");
        }
        h0 h0Var = new h0(this.f74536d, this.f74535c, this.f74537e, this.f74538f, this.f74539g, this.f74540h, this.f74541i, this.f74542j);
        if (this.f74544l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(objArr[i11]);
            a0VarArr[i11].a(h0Var, objArr[i11]);
        }
        return h0Var.k().tag(v.class, new v(this.f74533a, obj, this.f74534b, arrayList)).build();
    }
}
