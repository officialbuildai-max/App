package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1020a;

    /* renamed from: b, reason: collision with root package name */
    final w f1021b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f1022c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1023d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f1024e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f1025f;

    /* renamed from: g, reason: collision with root package name */
    ListView f1026g;

    /* renamed from: h, reason: collision with root package name */
    private View f1027h;

    /* renamed from: i, reason: collision with root package name */
    private int f1028i;

    /* renamed from: j, reason: collision with root package name */
    private int f1029j;

    /* renamed from: k, reason: collision with root package name */
    private int f1030k;

    /* renamed from: l, reason: collision with root package name */
    private int f1031l;

    /* renamed from: m, reason: collision with root package name */
    private int f1032m;

    /* renamed from: o, reason: collision with root package name */
    Button f1034o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f1035p;

    /* renamed from: q, reason: collision with root package name */
    Message f1036q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f1037r;

    /* renamed from: s, reason: collision with root package name */
    Button f1038s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f1039t;

    /* renamed from: u, reason: collision with root package name */
    Message f1040u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f1041v;

    /* renamed from: w, reason: collision with root package name */
    Button f1042w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f1043x;

    /* renamed from: y, reason: collision with root package name */
    Message f1044y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f1045z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1033n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass3(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.val$top, this.val$bottom);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass5(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f1026g, this.val$top, this.val$bottom);
        }
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        private final int f1046a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1047b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f1047b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1046a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f1046a, getPaddingRight(), z11 ? getPaddingBottom() : this.f1047b);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message obtain = (view != alertController.f1034o || (message3 = alertController.f1036q) == null) ? (view != alertController.f1038s || (message2 = alertController.f1040u) == null) ? (view != alertController.f1042w || (message = alertController.f1044y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f1021b).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f1049a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f1050b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f1052d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f1054f;

        /* renamed from: g, reason: collision with root package name */
        public View f1055g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f1056h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f1057i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f1058j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f1059k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f1060l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f1061m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f1062n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f1063o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f1064p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f1065q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f1067s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f1068t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f1069u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f1070v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f1071w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f1072x;

        /* renamed from: y, reason: collision with root package name */
        public int f1073y;

        /* renamed from: z, reason: collision with root package name */
        public View f1074z;

        /* renamed from: c, reason: collision with root package name */
        public int f1051c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f1053e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean O = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f1066r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1075a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i11, int i12, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i11, i12, charSequenceArr);
                this.f1075a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i11, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i11, view, viewGroup);
                boolean[] zArr = b.this.F;
                if (zArr != null && zArr[i11]) {
                    this.f1075a.setItemChecked(i11, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0020b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f1077a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1078b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1079c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f1080d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0020b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f1079c = recycleListView;
                this.f1080d = alertController;
                Cursor cursor2 = getCursor();
                this.f1077a = cursor2.getColumnIndexOrThrow(b.this.L);
                this.f1078b = cursor2.getColumnIndexOrThrow(b.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f1077a));
                this.f1079c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1078b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f1050b.inflate(this.f1080d.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f1082a;

            c(AlertController alertController) {
                this.f1082a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
                b.this.f1072x.onClick(this.f1082a.f1021b, i11);
                if (b.this.H) {
                    return;
                }
                this.f1082a.f1021b.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1084a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f1085b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f1084a = recycleListView;
                this.f1085b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
                boolean[] zArr = b.this.F;
                if (zArr != null) {
                    zArr[i11] = this.f1084a.isItemChecked(i11);
                }
                b.this.J.onClick(this.f1085b.f1021b, i11, this.f1084a.isItemChecked(i11));
            }
        }

        public b(Context context) {
            this.f1049a = context;
            this.f1050b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f1050b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                listAdapter = this.K == null ? new a(this.f1049a, alertController.M, R.id.text1, this.f1070v, recycleListView) : new C0020b(this.f1049a, this.K, false, recycleListView, alertController);
            } else {
                int i11 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f1049a, i11, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.f1071w;
                    if (listAdapter == null) {
                        listAdapter = new d(this.f1049a, i11, R.id.text1, this.f1070v);
                    }
                }
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f1072x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1026g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f1055g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f1054f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f1052d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i11 = this.f1051c;
                if (i11 != 0) {
                    alertController.m(i11);
                }
                int i12 = this.f1053e;
                if (i12 != 0) {
                    alertController.m(alertController.c(i12));
                }
            }
            CharSequence charSequence2 = this.f1056h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f1057i;
            if (charSequence3 != null || this.f1058j != null) {
                alertController.k(-1, charSequence3, this.f1059k, null, this.f1058j);
            }
            CharSequence charSequence4 = this.f1060l;
            if (charSequence4 != null || this.f1061m != null) {
                alertController.k(-2, charSequence4, this.f1062n, null, this.f1061m);
            }
            CharSequence charSequence5 = this.f1063o;
            if (charSequence5 != null || this.f1064p != null) {
                alertController.k(-3, charSequence5, this.f1065q, null, this.f1064p);
            }
            if (this.f1070v != null || this.K != null || this.f1071w != null) {
                b(alertController);
            }
            View view2 = this.f1074z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i13 = this.f1073y;
            if (i13 != 0) {
                alertController.r(i13);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f1087a;

        public c(DialogInterface dialogInterface) {
            this.f1087a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == -3 || i11 == -2 || i11 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1087a.get(), message.what);
            } else {
                if (i11 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends ArrayAdapter {
        public d(Context context, int i11, int i12, CharSequence[] charSequenceArr) {
            super(context, i11, i12, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, w wVar, Window window) {
        this.f1020a = context;
        this.f1021b = wVar;
        this.f1022c = window;
        this.R = new c(wVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f1023d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        wVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i11 = this.K;
        return (i11 != 0 && this.Q == 1) ? i11 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i11, int i12) {
        View findViewById = this.f1022c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f1022c.findViewById(R$id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(view, i11, i12);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i11;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f1034o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1035p) && this.f1037r == null) {
            this.f1034o.setVisibility(8);
            i11 = 0;
        } else {
            this.f1034o.setText(this.f1035p);
            Drawable drawable = this.f1037r;
            if (drawable != null) {
                int i12 = this.f1023d;
                drawable.setBounds(0, 0, i12, i12);
                this.f1034o.setCompoundDrawables(this.f1037r, null, null, null);
            }
            this.f1034o.setVisibility(0);
            i11 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f1038s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1039t) && this.f1041v == null) {
            this.f1038s.setVisibility(8);
        } else {
            this.f1038s.setText(this.f1039t);
            Drawable drawable2 = this.f1041v;
            if (drawable2 != null) {
                int i13 = this.f1023d;
                drawable2.setBounds(0, 0, i13, i13);
                this.f1038s.setCompoundDrawables(this.f1041v, null, null, null);
            }
            this.f1038s.setVisibility(0);
            i11 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f1042w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1043x) && this.f1045z == null) {
            this.f1042w.setVisibility(8);
        } else {
            this.f1042w.setText(this.f1043x);
            Drawable drawable3 = this.f1045z;
            if (drawable3 != null) {
                int i14 = this.f1023d;
                drawable3.setBounds(0, 0, i14, i14);
                this.f1042w.setCompoundDrawables(this.f1045z, null, null, null);
            }
            this.f1042w.setVisibility(0);
            i11 |= 4;
        }
        if (z(this.f1020a)) {
            if (i11 == 1) {
                b(this.f1034o);
            } else if (i11 == 2) {
                b(this.f1038s);
            } else if (i11 == 4) {
                b(this.f1042w);
            }
        }
        if (i11 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f1022c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f1025f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f1026g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f1026g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f1027h;
        if (view == null) {
            view = this.f1028i != 0 ? LayoutInflater.from(this.f1020a).inflate(this.f1028i, viewGroup, false) : null;
        }
        boolean z10 = view != null;
        if (!z10 || !a(view)) {
            this.f1022c.setFlags(131072, 131072);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f1022c.findViewById(R$id.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f1033n) {
            frameLayout.setPadding(this.f1029j, this.f1030k, this.f1031l, this.f1032m);
        }
        if (this.f1026g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1022c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f1022c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f1024e) || !this.P) {
            this.f1022c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f1022c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f1024e);
        int i11 = this.B;
        if (i11 != 0) {
            this.D.setImageResource(i11);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f1022c.findViewById(R$id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R$id.topPanel);
        View findViewById5 = findViewById3.findViewById(R$id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(R$id.topPanel);
        View findViewById8 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup i11 = i(findViewById7, findViewById4);
        ViewGroup i12 = i(findViewById8, findViewById5);
        ViewGroup i13 = i(findViewById9, findViewById6);
        v(i12);
        u(i13);
        x(i11);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (i11 == null || i11.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (i13 == null || i13.getVisibility() == 8) ? false : true;
        if (!z12 && i12 != null && (findViewById2 = i12.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f1025f == null && this.f1026g == null) ? null : i11.findViewById(R$id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (i12 != null && (findViewById = i12.findViewById(R$id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f1026g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z11, z12);
        }
        if (!z10) {
            View view = this.f1026g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(i12, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f1026g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i14 = this.I;
        if (i14 > -1) {
            listView2.setItemChecked(i14, true);
            listView2.setSelection(i14);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i11) {
        TypedValue typedValue = new TypedValue();
        this.f1020a.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f1026g;
    }

    public void e() {
        this.f1021b.setContentView(j());
        y();
    }

    public boolean g(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean h(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void k(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i11, onClickListener);
        }
        if (i11 == -3) {
            this.f1043x = charSequence;
            this.f1044y = message;
            this.f1045z = drawable;
        } else if (i11 == -2) {
            this.f1039t = charSequence;
            this.f1040u = message;
            this.f1041v = drawable;
        } else {
            if (i11 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f1035p = charSequence;
            this.f1036q = message;
            this.f1037r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i11) {
        this.C = null;
        this.B = i11;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i11 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f1025f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f1024e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i11) {
        this.f1027h = null;
        this.f1028i = i11;
        this.f1033n = false;
    }

    public void s(View view) {
        this.f1027h = view;
        this.f1028i = 0;
        this.f1033n = false;
    }

    public void t(View view, int i11, int i12, int i13, int i14) {
        this.f1027h = view;
        this.f1028i = 0;
        this.f1033n = true;
        this.f1029j = i11;
        this.f1030k = i12;
        this.f1031l = i13;
        this.f1032m = i14;
    }
}
