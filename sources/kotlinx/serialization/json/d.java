package kotlinx.serialization.json;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f68365a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f68366b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f68367c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f68368d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f68369e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f68370f;

    /* renamed from: g, reason: collision with root package name */
    private String f68371g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f68372h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f68373i;

    /* renamed from: j, reason: collision with root package name */
    private String f68374j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f68375k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f68376l;

    /* renamed from: m, reason: collision with root package name */
    private f00.c f68377m;

    public d(a json) {
        Intrinsics.h(json, "json");
        this.f68365a = json.e().e();
        this.f68366b = json.e().f();
        this.f68367c = json.e().g();
        this.f68368d = json.e().l();
        this.f68369e = json.e().b();
        this.f68370f = json.e().h();
        this.f68371g = json.e().i();
        this.f68372h = json.e().d();
        this.f68373i = json.e().k();
        this.f68374j = json.e().c();
        this.f68375k = json.e().a();
        this.f68376l = json.e().j();
        this.f68377m = json.a();
    }

    public final f a() {
        if (this.f68373i && !Intrinsics.c(this.f68374j, NativeComponentConstants.KEY_COMPONENT_TYPE)) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
        }
        if (this.f68370f) {
            if (!Intrinsics.c(this.f68371g, "    ")) {
                String str = this.f68371g;
                for (int i11 = 0; i11 < str.length(); i11++) {
                    char charAt = str.charAt(i11);
                    if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f68371g).toString());
                    }
                }
            }
        } else if (!Intrinsics.c(this.f68371g, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new f(this.f68365a, this.f68367c, this.f68368d, this.f68369e, this.f68370f, this.f68366b, this.f68371g, this.f68372h, this.f68373i, this.f68374j, this.f68375k, this.f68376l);
    }

    public final f00.c b() {
        return this.f68377m;
    }

    public final void c(boolean z10) {
        this.f68369e = z10;
    }

    public final void d(boolean z10) {
        this.f68365a = z10;
    }

    public final void e(boolean z10) {
        this.f68366b = z10;
    }

    public final void f(boolean z10) {
        this.f68367c = z10;
    }
}
