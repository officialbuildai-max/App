package com.cloud.tmc.miniapp.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.widget.OooO0O0;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooOO0 extends OooO0O0.OooO00o<OooOO0> {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final com.cloud.tmc.miniapp.dialog.OooO0o OooO0oO;
    public com.cloud.tmc.miniapp.dialog.OooOO0O OooO0oo;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<View> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return OooOO0.this.findViewById(R.id.view_padding1);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o implements BaseAdapter.OnItemClickListener {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnItemClickListener
        public void onItemClick(RecyclerView recyclerView, View view, int i11) {
            BottomActionSheetDialog$ActionItem item = OooOO0.this.OooO0oO.getItem(i11);
            if (Intrinsics.c(item.getId(), "Cancel")) {
                OooOO0.this.dismiss();
                return;
            }
            if (item.getEnable()) {
                OooOO0.this.dismiss();
                com.cloud.tmc.miniapp.dialog.OooOO0O oooOO0O = OooOO0.this.OooO0oo;
                if (oooOO0O != null) {
                    oooOO0O.OooO00o(i11, item);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function0<RecyclerView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (RecyclerView) OooOO0.this.findViewById(R.id.rv_action_items);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatTextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (AppCompatTextView) OooOO0.this.findViewById(R.id.tv_desc);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function0<AppCompatTextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (AppCompatTextView) OooOO0.this.findViewById(R.id.tv_title);
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.dialog.OooOO0$OooOO0, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0332OooOO0 extends Lambda implements Function0<View> {
        public C0332OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return OooOO0.this.findViewById(R.id.view_padding2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0O extends Lambda implements Function0<View> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return OooOO0.this.findViewById(R.id.view_padding3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOO0(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO());
        this.OooO0O0 = LazyKt.b(new C0332OooOO0());
        this.OooO0OO = LazyKt.b(new OooOO0O());
        this.OooO0Oo = LazyKt.b(new OooO0o());
        this.OooO0o0 = LazyKt.b(new OooO0OO());
        this.OooO0o = LazyKt.b(new OooO0O0());
        com.cloud.tmc.miniapp.dialog.OooO0o oooO0o = new com.cloud.tmc.miniapp.dialog.OooO0o(context);
        this.OooO0oO = oooO0o;
        setContentView(R.layout.mini_layout_bottom_action_sheet_dialog);
        setBackgroundDimEnabled(true);
        setBackgroundDimAmount(0.1f);
        oooO0o.setOnItemClickListener(new OooO00o());
        RecyclerView OooO00o2 = OooO00o();
        if (OooO00o2 == null) {
            return;
        }
        OooO00o2.setAdapter(oooO0o);
    }

    public final RecyclerView OooO00o() {
        return (RecyclerView) this.OooO0o.getValue();
    }

    public final OooOO0 OooO00o(ArrayList<BottomActionSheetDialog$ActionItem> data) {
        Intrinsics.h(data, "data");
        int size = data.size();
        if (1 > size || size >= 11) {
            TmcLogger.d("BottomActionSheetDialog", "Invalid " + size + ", must be between 1 and 10");
        } else {
            this.OooO0oO.setData(data);
        }
        return this;
    }

    public final AppCompatTextView OooO0O0() {
        return (AppCompatTextView) this.OooO0o0.getValue();
    }

    public final AppCompatTextView OooO0OO() {
        return (AppCompatTextView) this.OooO0Oo.getValue();
    }

    public final View OooO0Oo() {
        return (View) this.OooO00o.getValue();
    }

    public final View OooO0o() {
        return (View) this.OooO0OO.getValue();
    }

    public final View OooO0o0() {
        return (View) this.OooO0O0.getValue();
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooO00o
    public void show() {
        AppCompatTextView OooO0OO2;
        AppCompatTextView OooO0O02;
        AppCompatTextView OooO0O03;
        AppCompatTextView OooO0O04;
        AppCompatTextView OooO0O05;
        AppCompatTextView OooO0O06;
        AppCompatTextView OooO0OO3 = OooO0OO();
        if (OooO0OO3 == null || !ViewExtKt.getVisible(OooO0OO3) || (OooO0O06 = OooO0O0()) == null || !ViewExtKt.getVisible(OooO0O06)) {
            AppCompatTextView OooO0OO4 = OooO0OO();
            if ((OooO0OO4 == null || !ViewExtKt.getVisible(OooO0OO4) || (OooO0O04 = OooO0O0()) == null || ViewExtKt.getVisible(OooO0O04)) && ((OooO0OO2 = OooO0OO()) == null || ViewExtKt.getVisible(OooO0OO2) || (OooO0O03 = OooO0O0()) == null || !ViewExtKt.getVisible(OooO0O03))) {
                AppCompatTextView OooO0OO5 = OooO0OO();
                if (OooO0OO5 != null && !ViewExtKt.getVisible(OooO0OO5) && (OooO0O02 = OooO0O0()) != null && !ViewExtKt.getVisible(OooO0O02)) {
                    View OooO0Oo = OooO0Oo();
                    if (OooO0Oo != null) {
                        ViewExtKt.toGone(OooO0Oo);
                    }
                    View OooO0o0 = OooO0o0();
                    if (OooO0o0 != null) {
                        ViewExtKt.toGone(OooO0o0);
                    }
                    View OooO0o2 = OooO0o();
                    if (OooO0o2 != null) {
                        ViewExtKt.toGone(OooO0o2);
                    }
                }
            } else {
                View OooO0Oo2 = OooO0Oo();
                if (OooO0Oo2 != null) {
                    ViewExtKt.toVisible(OooO0Oo2);
                }
                View OooO0o02 = OooO0o0();
                if (OooO0o02 != null) {
                    ViewExtKt.toGone(OooO0o02);
                }
                View OooO0o3 = OooO0o();
                if (OooO0o3 != null) {
                    ViewExtKt.toVisible(OooO0o3);
                }
            }
        } else {
            View OooO0Oo3 = OooO0Oo();
            if (OooO0Oo3 != null) {
                ViewExtKt.toVisible(OooO0Oo3);
            }
            View OooO0o03 = OooO0o0();
            if (OooO0o03 != null) {
                ViewExtKt.toVisible(OooO0o03);
            }
            View OooO0o4 = OooO0o();
            if (OooO0o4 != null) {
                ViewExtKt.toVisible(OooO0o4);
            }
        }
        RecyclerView recyclerView = (RecyclerView) this.OooO0o.getValue();
        if (recyclerView != null) {
            Context context = getContext();
            Intrinsics.h(context, "context");
            OooO0O0.OooO00o params = new OooO0O0.OooO00o();
            params.OooO00o = 0;
            params.OooO0O0 = getColor(R.color.mini_color_E4E6EB_pure);
            params.OooO0OO = CommonExtKt.getDp2px(1);
            AppCompatTextView OooO0OO6 = OooO0OO();
            params.OooO0o0 = (OooO0OO6 != null && ViewExtKt.getVisible(OooO0OO6)) || ((OooO0O05 = OooO0O0()) != null && ViewExtKt.getVisible(OooO0O05));
            params.OooO0Oo = false;
            com.cloud.tmc.miniapp.widget.OooO0O0 oooO0O0 = new com.cloud.tmc.miniapp.widget.OooO0O0();
            Intrinsics.h(context, "context");
            Intrinsics.h(params, "params");
            oooO0O0.OooO0o0 = params.OooO00o;
            oooO0O0.OooO00o = params.OooO0O0;
            oooO0O0.OooO0O0 = params.OooO0OO;
            oooO0O0.OooO0OO = params.OooO0o0;
            oooO0O0.OooO0Oo = params.OooO0Oo;
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), 0);
            oooO0O0.OooO0oO = decodeResource;
            if (decodeResource != null) {
                Intrinsics.e(decodeResource);
                if (decodeResource.getNinePatchChunk() != null) {
                    Bitmap bitmap = oooO0O0.OooO0oO;
                    Intrinsics.e(bitmap);
                    new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
                }
                if (oooO0O0.OooO0o0 == 0 && oooO0O0.OooO0O0 == 0) {
                    Bitmap bitmap2 = oooO0O0.OooO0oO;
                    Intrinsics.e(bitmap2);
                    bitmap2.getHeight();
                }
                if (oooO0O0.OooO0o0 == 1 && oooO0O0.OooO0O0 == 0) {
                    Bitmap bitmap3 = oooO0O0.OooO0oO;
                    Intrinsics.e(bitmap3);
                    bitmap3.getWidth();
                }
            }
            Paint paint = new Paint();
            paint.setColor(oooO0O0.OooO00o);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(oooO0O0.OooO0O0);
            oooO0O0.OooO0o = paint;
            recyclerView.addItemDecoration(oooO0O0);
        }
        super.show();
    }
}
