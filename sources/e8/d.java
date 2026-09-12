package e8;

/* loaded from: classes4.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private c[] f61729a;

    public d(c... cVarArr) {
        this.f61729a = cVarArr;
    }

    @Override // e8.c
    public void a(int i11, String str, String str2) {
        for (c cVar : this.f61729a) {
            cVar.a(i11, str, str2);
        }
    }
}
