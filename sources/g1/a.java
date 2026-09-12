package g1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import g1.b;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f63188a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f63189b;

    /* renamed from: c, reason: collision with root package name */
    protected Cursor f63190c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f63191d;

    /* renamed from: e, reason: collision with root package name */
    protected int f63192e;

    /* renamed from: f, reason: collision with root package name */
    protected C0789a f63193f;

    /* renamed from: g, reason: collision with root package name */
    protected DataSetObserver f63194g;

    /* renamed from: h, reason: collision with root package name */
    protected g1.b f63195h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0789a extends ContentObserver {
        C0789a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f63188a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f63188a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        f(context, cursor, z10 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j11 = j(cursor);
        if (j11 != null) {
            j11.close();
        }
    }

    public abstract CharSequence b(Cursor cursor);

    @Override // g1.b.a
    public Cursor d() {
        return this.f63190c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i11) {
        if ((i11 & 1) == 1) {
            i11 |= 2;
            this.f63189b = true;
        } else {
            this.f63189b = false;
        }
        boolean z10 = cursor != null;
        this.f63190c = cursor;
        this.f63188a = z10;
        this.f63191d = context;
        this.f63192e = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i11 & 2) == 2) {
            this.f63193f = new C0789a();
            this.f63194g = new b();
        } else {
            this.f63193f = null;
            this.f63194g = null;
        }
        if (z10) {
            C0789a c0789a = this.f63193f;
            if (c0789a != null) {
                cursor.registerContentObserver(c0789a);
            }
            DataSetObserver dataSetObserver = this.f63194g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f63188a || (cursor = this.f63190c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f63188a) {
            return null;
        }
        this.f63190c.moveToPosition(i11);
        if (view == null) {
            view = g(this.f63191d, this.f63190c, viewGroup);
        }
        e(view, this.f63191d, this.f63190c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f63195h == null) {
            this.f63195h = new g1.b(this);
        }
        return this.f63195h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i11) {
        Cursor cursor;
        if (!this.f63188a || (cursor = this.f63190c) == null) {
            return null;
        }
        cursor.moveToPosition(i11);
        return this.f63190c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        Cursor cursor;
        if (this.f63188a && (cursor = this.f63190c) != null && cursor.moveToPosition(i11)) {
            return this.f63190c.getLong(this.f63192e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f63188a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f63190c.moveToPosition(i11)) {
            if (view == null) {
                view = h(this.f63191d, this.f63190c, viewGroup);
            }
            e(view, this.f63191d, this.f63190c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i11);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f63189b || (cursor = this.f63190c) == null || cursor.isClosed()) {
            return;
        }
        this.f63188a = this.f63190c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f63190c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0789a c0789a = this.f63193f;
            if (c0789a != null) {
                cursor2.unregisterContentObserver(c0789a);
            }
            DataSetObserver dataSetObserver = this.f63194g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f63190c = cursor;
        if (cursor != null) {
            C0789a c0789a2 = this.f63193f;
            if (c0789a2 != null) {
                cursor.registerContentObserver(c0789a2);
            }
            DataSetObserver dataSetObserver2 = this.f63194g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f63192e = cursor.getColumnIndexOrThrow("_id");
            this.f63188a = true;
            notifyDataSetChanged();
        } else {
            this.f63192e = -1;
            this.f63188a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
