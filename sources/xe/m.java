package xe;

/* loaded from: classes5.dex */
public class m extends g {

    /* renamed from: c, reason: collision with root package name */
    private boolean f78348c;

    public m(com.google.zxing.i iVar) {
        super(iVar);
        this.f78348c = true;
    }

    @Override // xe.g
    protected com.google.zxing.b e(com.google.zxing.e eVar) {
        if (this.f78348c) {
            this.f78348c = false;
            return new com.google.zxing.b(new id.l(eVar.e()));
        }
        this.f78348c = true;
        return new com.google.zxing.b(new id.l(eVar));
    }
}
