package p4;

import java.util.List;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f72413a;

    /* renamed from: b, reason: collision with root package name */
    private final char f72414b;

    /* renamed from: c, reason: collision with root package name */
    private final double f72415c;

    /* renamed from: d, reason: collision with root package name */
    private final double f72416d;

    /* renamed from: e, reason: collision with root package name */
    private final String f72417e;

    /* renamed from: f, reason: collision with root package name */
    private final String f72418f;

    public c(List list, char c11, double d11, double d12, String str, String str2) {
        this.f72413a = list;
        this.f72414b = c11;
        this.f72415c = d11;
        this.f72416d = d12;
        this.f72417e = str;
        this.f72418f = str2;
    }

    public static int c(char c11, String str, String str2) {
        return (((c11 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f72413a;
    }

    public double b() {
        return this.f72416d;
    }

    public int hashCode() {
        return c(this.f72414b, this.f72418f, this.f72417e);
    }
}
