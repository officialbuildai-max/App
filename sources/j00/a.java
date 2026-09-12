package j00;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f65826a = new DataSetObservable();

    public abstract int a();

    public abstract c b(Context context);

    public abstract d c(Context context, int i11);

    public float d(Context context, int i11) {
        return 1.0f;
    }

    public final void e() {
        this.f65826a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.f65826a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.f65826a.unregisterObserver(dataSetObserver);
    }
}
