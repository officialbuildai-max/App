package x9;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f78274a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78275b;

    public o(String str, String str2) {
        this.f78274a = str;
        this.f78275b = str2;
    }

    public String toString() {
        String str = this.f78274a;
        String str2 = this.f78275b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        return sb2.toString();
    }
}
