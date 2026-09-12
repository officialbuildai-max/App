package sr;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$drawable;
import com.transsion.shorttv._channel.model.ShortTvFilterVal;
import com.transsion.shorttv._channel.model.ShortTvItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sr.r;

/* loaded from: classes7.dex */
public final class r extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f75965a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f75966b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f75967c;

    /* renamed from: d, reason: collision with root package name */
    private a f75968d;

    /* renamed from: e, reason: collision with root package name */
    private Function1 f75969e;

    /* renamed from: f, reason: collision with root package name */
    private ShortTvItem f75970f;

    /* renamed from: g, reason: collision with root package name */
    private String f75971g;

    /* loaded from: classes7.dex */
    public final class a extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final List f75972a;

        /* renamed from: b, reason: collision with root package name */
        private final String f75973b;

        /* renamed from: c, reason: collision with root package name */
        private final Function1 f75974c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f75975d;

        /* renamed from: sr.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0944a extends RecyclerView.b0 {

            /* renamed from: a, reason: collision with root package name */
            private final TextView f75976a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f75977b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0944a(a aVar, View itemView) {
                super(itemView);
                Intrinsics.h(itemView, "itemView");
                this.f75977b = aVar;
                this.f75976a = (TextView) itemView;
            }

            public final TextView f() {
                return this.f75976a;
            }
        }

        public a(r rVar, List data, String str, Function1 onItemClick) {
            Intrinsics.h(data, "data");
            Intrinsics.h(onItemClick, "onItemClick");
            this.f75975d = rVar;
            this.f75972a = data;
            this.f75973b = str;
            this.f75974c = onItemClick;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(a aVar, ShortTvFilterVal shortTvFilterVal, View view) {
            aVar.f75974c.invoke(shortTvFilterVal);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f75972a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0944a holder, int i11) {
            Intrinsics.h(holder, "holder");
            final ShortTvFilterVal shortTvFilterVal = (ShortTvFilterVal) this.f75972a.get(i11);
            holder.f().setText(shortTvFilterVal.getName());
            if (Intrinsics.c(shortTvFilterVal.getId(), this.f75973b)) {
                holder.f().setTextColor(-1);
                holder.f().setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                holder.f().setTextColor(-1);
                holder.f().setTypeface(Typeface.DEFAULT);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: sr.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.a.i(r.a.this, shortTvFilterVal, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C0944a onCreateViewHolder(ViewGroup parent, int i11) {
            Intrinsics.h(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setPadding(a0.a(16.0f), 0, a0.a(16.0f), a0.a(37.0f));
            textView.setGravity(8388627);
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            return new C0944a(this, textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
        super(context, R.style.Theme.Black.NoTitleBar.Fullscreen);
        Intrinsics.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(r rVar, View view) {
        rVar.dismiss();
        Function1 function1 = rVar.f75969e;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(r rVar, ShortTvFilterVal selected) {
        Intrinsics.h(selected, "selected");
        rVar.dismiss();
        Function1 function1 = rVar.f75969e;
        if (function1 != null) {
            function1.invoke(selected.getId());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(r rVar, View view) {
        rVar.dismiss();
        Function1 function1 = rVar.f75969e;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(r rVar, Function1 function1, ShortTvFilterVal selected) {
        Intrinsics.h(selected, "selected");
        rVar.dismiss();
        function1.invoke(selected.getId());
        return Unit.f67184a;
    }

    public final void j(ShortTvItem item, String str, final Function1 callback) {
        Intrinsics.h(item, "item");
        Intrinsics.h(callback, "callback");
        this.f75970f = item;
        this.f75971g = str;
        this.f75969e = callback;
        if (!isShowing()) {
            show();
            return;
        }
        TextView textView = this.f75966b;
        RecyclerView recyclerView = null;
        if (textView == null) {
            Intrinsics.z("mTitleTv");
            textView = null;
        }
        textView.setText(item.getTitle());
        this.f75968d = new a(this, item.getFilterValsV2(), str, new Function1() { // from class: sr.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = r.k(r.this, callback, (ShortTvFilterVal) obj);
                return k11;
            }
        });
        RecyclerView recyclerView2 = this.f75965a;
        if (recyclerView2 == null) {
            Intrinsics.z("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setAdapter(this.f75968d);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.addFlags(Integer.MIN_VALUE);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setStatusBarColor(getContext().getResources().getColor(R$color.short_tv_black_90));
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(linearLayout.getContext().getResources().getColor(R$color.short_tv_black_90));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: sr.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.f(r.this, view);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(a0.a(16.0f), a0.a(12.0f), a0.a(16.0f), a0.a(12.0f));
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setClickable(true);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: sr.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.h(view);
            }
        });
        TextView textView = new TextView(getContext());
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f75966b = textView;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R$drawable.short_tv_music_iv_close);
        imageView.setColorFilter(imageView.getContext().getResources().getColor(R$color.short_tv_white));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a0.a(21.0f), a0.a(21.0f)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: sr.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.i(r.this, view);
            }
        });
        this.f75967c = imageView;
        TextView textView2 = this.f75966b;
        RecyclerView recyclerView = null;
        if (textView2 == null) {
            Intrinsics.z("mTitleTv");
            textView2 = null;
        }
        linearLayout2.addView(textView2);
        ImageView imageView2 = this.f75967c;
        if (imageView2 == null) {
            Intrinsics.z("mCloseBtn");
            imageView2 = null;
        }
        linearLayout2.addView(imageView2);
        linearLayout.addView(linearLayout2);
        View view = new View(getContext());
        view.setBackgroundColor(view.getContext().getResources().getColor(R$color.short_tv_white_10));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.a(1.0f)));
        linearLayout.addView(view);
        RecyclerView recyclerView2 = new RecyclerView(getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        recyclerView2.setPadding(0, a0.a(23.0f), 0, a0.a(40.0f));
        recyclerView2.setClipToPadding(false);
        recyclerView2.setClickable(true);
        this.f75965a = recyclerView2;
        linearLayout.addView(recyclerView2);
        setContentView(linearLayout);
        ShortTvItem shortTvItem = this.f75970f;
        if (shortTvItem != null) {
            TextView textView3 = this.f75966b;
            if (textView3 == null) {
                Intrinsics.z("mTitleTv");
                textView3 = null;
            }
            textView3.setText(shortTvItem.getTitle());
            this.f75968d = new a(this, shortTvItem.getFilterValsV2(), this.f75971g, new Function1() { // from class: sr.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g11;
                    g11 = r.g(r.this, (ShortTvFilterVal) obj);
                    return g11;
                }
            });
            RecyclerView recyclerView3 = this.f75965a;
            if (recyclerView3 == null) {
                Intrinsics.z("mRecyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAdapter(this.f75968d);
        }
    }
}
