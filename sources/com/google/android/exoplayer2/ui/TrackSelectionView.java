package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f27134a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutInflater f27135b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckedTextView f27136c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckedTextView f27137d;

    /* renamed from: e, reason: collision with root package name */
    private final b f27138e;

    /* renamed from: f, reason: collision with root package name */
    private final SparseArray f27139f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f27140g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f27141h;

    /* renamed from: i, reason: collision with root package name */
    private o0 f27142i;

    /* renamed from: j, reason: collision with root package name */
    private CheckedTextView[][] f27143j;

    /* renamed from: k, reason: collision with root package name */
    private i.a f27144k;

    /* renamed from: l, reason: collision with root package name */
    private int f27145l;

    /* renamed from: m, reason: collision with root package name */
    private t9.x f27146m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f27147n;

    /* renamed from: o, reason: collision with root package name */
    private Comparator f27148o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.f(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f27150a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27151b;

        /* renamed from: c, reason: collision with root package name */
        public final o1 f27152c;

        public c(int i11, int i12, o1 o1Var) {
            this.f27150a = i11;
            this.f27151b = i12;
            this.f27152c = o1Var;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setOrientation(1);
        this.f27139f = new SparseArray();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f27134a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f27135b = from;
        b bVar = new b();
        this.f27138e = bVar;
        this.f27142i = new g(getResources());
        this.f27146m = t9.x.f76286d;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f27136c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f27137d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    private static int[] c(int[] iArr, int i11) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i11;
        return copyOf;
    }

    private static int[] d(int[] iArr, int i11) {
        int[] iArr2 = new int[iArr.length - 1];
        int i12 = 0;
        for (int i13 : iArr) {
            if (i13 != i11) {
                iArr2[i12] = i13;
                i12++;
            }
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.f27152c, cVar2.f27152c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view) {
        if (view == this.f27136c) {
            h();
        } else if (view == this.f27137d) {
            g();
        } else {
            i(view);
        }
        l();
    }

    private void g() {
        this.f27147n = false;
        this.f27139f.clear();
    }

    private void h() {
        this.f27147n = true;
        this.f27139f.clear();
    }

    private void i(View view) {
        this.f27147n = false;
        c cVar = (c) com.google.android.exoplayer2.util.a.e(view.getTag());
        int i11 = cVar.f27150a;
        int i12 = cVar.f27151b;
        e.C0380e c0380e = (e.C0380e) this.f27139f.get(i11);
        com.google.android.exoplayer2.util.a.e(this.f27144k);
        if (c0380e == null) {
            if (!this.f27141h && this.f27139f.size() > 0) {
                this.f27139f.clear();
            }
            this.f27139f.put(i11, new e.C0380e(i11, i12));
            return;
        }
        int i13 = c0380e.f26891c;
        int[] iArr = c0380e.f26890b;
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean j11 = j(i11);
        boolean z10 = j11 || k();
        if (isChecked && z10) {
            if (i13 == 1) {
                this.f27139f.remove(i11);
                return;
            } else {
                this.f27139f.put(i11, new e.C0380e(i11, d(iArr, i12)));
                return;
            }
        }
        if (isChecked) {
            return;
        }
        if (j11) {
            this.f27139f.put(i11, new e.C0380e(i11, c(iArr, i12)));
        } else {
            this.f27139f.put(i11, new e.C0380e(i11, i12));
        }
    }

    private boolean j(int i11) {
        return this.f27140g && this.f27146m.b(i11).f25727a > 1 && this.f27144k.a(this.f27145l, i11, false) != 0;
    }

    private boolean k() {
        return this.f27141h && this.f27146m.f76288a > 1;
    }

    private void l() {
        this.f27136c.setChecked(this.f27147n);
        this.f27137d.setChecked(!this.f27147n && this.f27139f.size() == 0);
        for (int i11 = 0; i11 < this.f27143j.length; i11++) {
            e.C0380e c0380e = (e.C0380e) this.f27139f.get(i11);
            int i12 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f27143j[i11];
                if (i12 < checkedTextViewArr.length) {
                    if (c0380e != null) {
                        this.f27143j[i11][i12].setChecked(c0380e.b(((c) com.google.android.exoplayer2.util.a.e(checkedTextViewArr[i12].getTag())).f27151b));
                    } else {
                        checkedTextViewArr[i12].setChecked(false);
                    }
                    i12++;
                }
            }
        }
    }

    private void m() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f27144k == null) {
            this.f27136c.setEnabled(false);
            this.f27137d.setEnabled(false);
            return;
        }
        this.f27136c.setEnabled(true);
        this.f27137d.setEnabled(true);
        t9.x f11 = this.f27144k.f(this.f27145l);
        this.f27146m = f11;
        this.f27143j = new CheckedTextView[f11.f76288a];
        boolean k11 = k();
        int i11 = 0;
        while (true) {
            t9.x xVar = this.f27146m;
            if (i11 >= xVar.f76288a) {
                l();
                return;
            }
            TrackGroup b11 = xVar.b(i11);
            boolean j11 = j(i11);
            CheckedTextView[][] checkedTextViewArr = this.f27143j;
            int i12 = b11.f25727a;
            checkedTextViewArr[i11] = new CheckedTextView[i12];
            c[] cVarArr = new c[i12];
            for (int i13 = 0; i13 < b11.f25727a; i13++) {
                cVarArr[i13] = new c(i11, i13, b11.c(i13));
            }
            Comparator comparator = this.f27148o;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                if (i14 == 0) {
                    addView(this.f27135b.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f27135b.inflate((j11 || k11) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f27134a);
                checkedTextView.setText(this.f27142i.a(cVarArr[i14].f27152c));
                checkedTextView.setTag(cVarArr[i14]);
                if (this.f27144k.g(this.f27145l, i11, i14) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f27138e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f27143j[i11][i14] = checkedTextView;
                addView(checkedTextView);
            }
            i11++;
        }
    }

    public boolean getIsDisabled() {
        return this.f27147n;
    }

    public List<e.C0380e> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f27139f.size());
        for (int i11 = 0; i11 < this.f27139f.size(); i11++) {
            arrayList.add((e.C0380e) this.f27139f.valueAt(i11));
        }
        return arrayList;
    }

    public void init(i.a aVar, int i11, boolean z10, List<e.C0380e> list, @Nullable final Comparator<o1> comparator, @Nullable d dVar) {
        this.f27144k = aVar;
        this.f27145l = i11;
        this.f27147n = z10;
        this.f27148o = comparator == null ? null : new Comparator() { // from class: com.google.android.exoplayer2.ui.p0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e11;
                e11 = TrackSelectionView.e(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
                return e11;
            }
        };
        int size = this.f27141h ? list.size() : Math.min(list.size(), 1);
        for (int i12 = 0; i12 < size; i12++) {
            e.C0380e c0380e = list.get(i12);
            this.f27139f.put(c0380e.f26889a, c0380e);
        }
        m();
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f27140g != z10) {
            this.f27140g = z10;
            m();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f27141h != z10) {
            this.f27141h = z10;
            if (!z10 && this.f27139f.size() > 1) {
                for (int size = this.f27139f.size() - 1; size > 0; size--) {
                    this.f27139f.remove(size);
                }
            }
            m();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f27136c.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(o0 o0Var) {
        this.f27142i = (o0) com.google.android.exoplayer2.util.a.e(o0Var);
        m();
    }
}
