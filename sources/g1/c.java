package g1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    private int f63199i;

    /* renamed from: j, reason: collision with root package name */
    private int f63200j;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f63201k;

    public c(Context context, int i11, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f63200j = i11;
        this.f63199i = i11;
        this.f63201k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // g1.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f63201k.inflate(this.f63200j, viewGroup, false);
    }

    @Override // g1.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f63201k.inflate(this.f63199i, viewGroup, false);
    }
}
