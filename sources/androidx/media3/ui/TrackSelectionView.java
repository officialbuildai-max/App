package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.i0;
import androidx.media3.ui.TrackSelectionView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f13689a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutInflater f13690b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckedTextView f13691c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckedTextView f13692d;

    /* renamed from: e, reason: collision with root package name */
    private final b f13693e;

    /* renamed from: f, reason: collision with root package name */
    private final List f13694f;

    /* renamed from: g, reason: collision with root package name */
    private final Map f13695g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13696h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13697i;

    /* renamed from: j, reason: collision with root package name */
    private z0 f13698j;

    /* renamed from: k, reason: collision with root package name */
    private CheckedTextView[][] f13699k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13700l;

    /* renamed from: m, reason: collision with root package name */
    private Comparator f13701m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final i0.a f13703a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13704b;

        public c(i0.a aVar, int i11) {
            this.f13703a = aVar;
            this.f13704b = i11;
        }

        public androidx.media3.common.r a() {
            return this.f13703a.b(this.f13704b);
        }
    }

    /* loaded from: classes2.dex */
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
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f13689a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f13690b = from;
        b bVar = new b();
        this.f13693e = bVar;
        this.f13698j = new f(getResources());
        this.f13694f = new ArrayList();
        this.f13695g = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f13691c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f13692d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.a(), cVar2.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        if (view == this.f13691c) {
            f();
        } else if (view == this.f13692d) {
            e();
        } else {
            g(view);
        }
        j();
    }

    private void e() {
        this.f13700l = false;
        this.f13695g.clear();
    }

    private void f() {
        this.f13700l = true;
        this.f13695g.clear();
    }

    public static Map<androidx.media3.common.f0, androidx.media3.common.g0> filterOverrides(Map<androidx.media3.common.f0, androidx.media3.common.g0> map, List<i0.a> list, boolean z10) {
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < list.size(); i11++) {
            androidx.media3.common.g0 g0Var = map.get(list.get(i11).a());
            if (g0Var != null && (z10 || hashMap.isEmpty())) {
                hashMap.put(g0Var.f10061a, g0Var);
            }
        }
        return hashMap;
    }

    private void g(View view) {
        this.f13700l = false;
        c cVar = (c) androidx.media3.common.util.a.e(view.getTag());
        androidx.media3.common.f0 a11 = cVar.f13703a.a();
        int i11 = cVar.f13704b;
        androidx.media3.common.g0 g0Var = (androidx.media3.common.g0) this.f13695g.get(a11);
        if (g0Var == null) {
            if (!this.f13697i && this.f13695g.size() > 0) {
                this.f13695g.clear();
            }
            this.f13695g.put(a11, new androidx.media3.common.g0(a11, ImmutableList.of(Integer.valueOf(i11))));
            return;
        }
        ArrayList arrayList = new ArrayList(g0Var.f10062b);
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean h11 = h(cVar.f13703a);
        boolean z10 = h11 || i();
        if (isChecked && z10) {
            arrayList.remove(Integer.valueOf(i11));
            if (arrayList.isEmpty()) {
                this.f13695g.remove(a11);
                return;
            } else {
                this.f13695g.put(a11, new androidx.media3.common.g0(a11, arrayList));
                return;
            }
        }
        if (isChecked) {
            return;
        }
        if (!h11) {
            this.f13695g.put(a11, new androidx.media3.common.g0(a11, ImmutableList.of(Integer.valueOf(i11))));
        } else {
            arrayList.add(Integer.valueOf(i11));
            this.f13695g.put(a11, new androidx.media3.common.g0(a11, arrayList));
        }
    }

    private boolean h(i0.a aVar) {
        return this.f13696h && aVar.e();
    }

    private boolean i() {
        return this.f13697i && this.f13694f.size() > 1;
    }

    private void j() {
        this.f13691c.setChecked(this.f13700l);
        this.f13692d.setChecked(!this.f13700l && this.f13695g.size() == 0);
        for (int i11 = 0; i11 < this.f13699k.length; i11++) {
            androidx.media3.common.g0 g0Var = (androidx.media3.common.g0) this.f13695g.get(((i0.a) this.f13694f.get(i11)).a());
            int i12 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f13699k[i11];
                if (i12 < checkedTextViewArr.length) {
                    if (g0Var != null) {
                        this.f13699k[i11][i12].setChecked(g0Var.f10062b.contains(Integer.valueOf(((c) androidx.media3.common.util.a.e(checkedTextViewArr[i12].getTag())).f13704b)));
                    } else {
                        checkedTextViewArr[i12].setChecked(false);
                    }
                    i12++;
                }
            }
        }
    }

    private void k() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f13694f.isEmpty()) {
            this.f13691c.setEnabled(false);
            this.f13692d.setEnabled(false);
            return;
        }
        this.f13691c.setEnabled(true);
        this.f13692d.setEnabled(true);
        this.f13699k = new CheckedTextView[this.f13694f.size()];
        boolean i11 = i();
        for (int i12 = 0; i12 < this.f13694f.size(); i12++) {
            i0.a aVar = (i0.a) this.f13694f.get(i12);
            boolean h11 = h(aVar);
            CheckedTextView[][] checkedTextViewArr = this.f13699k;
            int i13 = aVar.f10173a;
            checkedTextViewArr[i12] = new CheckedTextView[i13];
            c[] cVarArr = new c[i13];
            for (int i14 = 0; i14 < aVar.f10173a; i14++) {
                cVarArr[i14] = new c(aVar, i14);
            }
            Comparator comparator = this.f13701m;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i15 = 0; i15 < i13; i15++) {
                if (i15 == 0) {
                    addView(this.f13690b.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f13690b.inflate((h11 || i11) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f13689a);
                checkedTextView.setText(this.f13698j.a(cVarArr[i15].a()));
                checkedTextView.setTag(cVarArr[i15]);
                if (aVar.i(i15)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f13693e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f13699k[i12][i15] = checkedTextView;
                addView(checkedTextView);
            }
        }
        j();
    }

    public boolean getIsDisabled() {
        return this.f13700l;
    }

    public Map<androidx.media3.common.f0, androidx.media3.common.g0> getOverrides() {
        return this.f13695g;
    }

    public void init(List<i0.a> list, boolean z10, Map<androidx.media3.common.f0, androidx.media3.common.g0> map, @Nullable final Comparator<androidx.media3.common.r> comparator, @Nullable d dVar) {
        this.f13700l = z10;
        this.f13701m = comparator == null ? null : new Comparator() { // from class: androidx.media3.ui.a1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c11;
                c11 = TrackSelectionView.c(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
                return c11;
            }
        };
        this.f13694f.clear();
        this.f13694f.addAll(list);
        this.f13695g.clear();
        this.f13695g.putAll(filterOverrides(map, list, this.f13697i));
        k();
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f13696h != z10) {
            this.f13696h = z10;
            k();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f13697i != z10) {
            this.f13697i = z10;
            if (!z10 && this.f13695g.size() > 1) {
                Map<androidx.media3.common.f0, androidx.media3.common.g0> filterOverrides = filterOverrides(this.f13695g, this.f13694f, false);
                this.f13695g.clear();
                this.f13695g.putAll(filterOverrides);
            }
            k();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f13691c.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(z0 z0Var) {
        this.f13698j = (z0) androidx.media3.common.util.a.e(z0Var);
        k();
    }
}
