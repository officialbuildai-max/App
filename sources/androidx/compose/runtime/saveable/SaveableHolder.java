package androidx.compose.runtime.saveable;

import androidx.compose.runtime.b2;
import androidx.compose.runtime.saveable.b;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SaveableHolder implements e, b2 {

    /* renamed from: a, reason: collision with root package name */
    private d f3962a;

    /* renamed from: b, reason: collision with root package name */
    private b f3963b;

    /* renamed from: c, reason: collision with root package name */
    private String f3964c;

    /* renamed from: d, reason: collision with root package name */
    private Object f3965d;

    /* renamed from: e, reason: collision with root package name */
    private Object[] f3966e;

    /* renamed from: f, reason: collision with root package name */
    private b.a f3967f;

    /* renamed from: g, reason: collision with root package name */
    private final Function0 f3968g = new Function0<Object>() { // from class: androidx.compose.runtime.saveable.SaveableHolder$valueProvider$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d dVar;
            Object obj;
            dVar = SaveableHolder.this.f3962a;
            SaveableHolder saveableHolder = SaveableHolder.this;
            obj = saveableHolder.f3965d;
            if (obj != null) {
                return dVar.a(saveableHolder, obj);
            }
            throw new IllegalArgumentException("Value should be initialized");
        }
    };

    public SaveableHolder(d dVar, b bVar, String str, Object obj, Object[] objArr) {
        this.f3962a = dVar;
        this.f3963b = bVar;
        this.f3964c = str;
        this.f3965d = obj;
        this.f3966e = objArr;
    }

    private final void e() {
        b bVar = this.f3963b;
        if (this.f3967f == null) {
            if (bVar != null) {
                RememberSaveableKt.d(bVar, this.f3968g.invoke());
                this.f3967f = bVar.b(this.f3964c, this.f3968g);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("entry(" + this.f3967f + ") is not null").toString());
    }

    @Override // androidx.compose.runtime.saveable.e
    public boolean a(Object obj) {
        b bVar = this.f3963b;
        return bVar == null || bVar.a(obj);
    }

    public final Object d(Object[] objArr) {
        if (Arrays.equals(objArr, this.f3966e)) {
            return this.f3965d;
        }
        return null;
    }

    public final void f(d dVar, b bVar, String str, Object obj, Object[] objArr) {
        boolean z10;
        boolean z11 = true;
        if (this.f3963b != bVar) {
            this.f3963b = bVar;
            z10 = true;
        } else {
            z10 = false;
        }
        if (Intrinsics.c(this.f3964c, str)) {
            z11 = z10;
        } else {
            this.f3964c = str;
        }
        this.f3962a = dVar;
        this.f3965d = obj;
        this.f3966e = objArr;
        b.a aVar = this.f3967f;
        if (aVar == null || !z11) {
            return;
        }
        if (aVar != null) {
            aVar.unregister();
        }
        this.f3967f = null;
        e();
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        b.a aVar = this.f3967f;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        b.a aVar = this.f3967f;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        e();
    }
}
