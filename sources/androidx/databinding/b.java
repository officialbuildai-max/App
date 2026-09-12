package androidx.databinding;

import androidx.databinding.i;

/* loaded from: classes.dex */
abstract class b extends androidx.databinding.a {

    /* loaded from: classes.dex */
    class a extends i.a {
        a() {
        }

        @Override // androidx.databinding.i.a
        public void a(i iVar, int i11) {
            b.this.notifyChange();
        }
    }

    public b() {
    }

    public b(i... iVarArr) {
        if (iVarArr == null || iVarArr.length == 0) {
            return;
        }
        a aVar = new a();
        for (i iVar : iVarArr) {
            iVar.addOnPropertyChangedCallback(aVar);
        }
    }
}
