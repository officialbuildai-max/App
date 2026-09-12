package com.cloud.tmc.miniapp.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.callback.OnPhotoSelectListener;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.action.StatusAction;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.dialog.o00Oo0;
import com.cloud.tmc.miniapp.dialog.o00Ooo;
import com.cloud.tmc.miniapp.dialog.oo000o;
import com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.OooO;
import com.cloud.tmc.miniapp.widget.OooO00o;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ImageSelectActivity extends BaseActivity implements StatusAction, Runnable, BaseAdapter.OnItemClickListener, BaseAdapter.OnChildClickListener {
    private static final String IMAGE_MAX_SELECT = "maxSelect";
    private static final String IMAGE_SELECT_LIST = "imageList";
    public static final int SELECT_MODE_MULTIPLE = 2;
    public static final int SELECT_MODE_PREVIEW = 3;
    public static final int SELECT_MODE_SINGLE = 1;
    private final ImageSelectAdapter adapter;
    private o00Ooo albumDialog;
    private final ConcurrentHashMap<String, List<String>> allAlbum;
    private final ArrayList<String> allImage;
    private final ArrayList<String> selectImage;
    private final ArrayList<Integer> selectPosition;
    private final ArrayList<String> tempData;
    public static final Companion Companion = new Companion(null);
    private static int selectMode = 1;
    private final Lazy flTitleBack$delegate = LazyKt.b(new Function0<FrameLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$flTitleBack$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final FrameLayout invoke() {
            return (FrameLayout) ImageSelectActivity.this.findViewById(R.id.fl_title_back);
        }
    });
    private final Lazy tvTitle$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$tvTitle$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            return (TextView) ImageSelectActivity.this.findViewById(R.id.tv_title);
        }
    });
    private final Lazy ivImageSelect$delegate = LazyKt.b(new Function0<AppCompatImageView>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$ivImageSelect$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final AppCompatImageView invoke() {
            return (AppCompatImageView) ImageSelectActivity.this.findViewById(R.id.iv_image_select);
        }
    });
    private final Lazy slImageSelectStatus$delegate = LazyKt.b(new Function0<StatusLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$slImageSelectStatus$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final StatusLayout invoke() {
            return (StatusLayout) ImageSelectActivity.this.findViewById(R.id.sl_image_select_status);
        }
    });
    private final Lazy rvImageSelectList$delegate = LazyKt.b(new Function0<RecyclerView>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$rvImageSelectList$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RecyclerView invoke() {
            return (RecyclerView) ImageSelectActivity.this.findViewById(R.id.rv_image_select_list);
        }
    });
    private final Lazy llAlbumSelect$delegate = LazyKt.b(new Function0<LinearLayoutCompat>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$llAlbumSelect$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final LinearLayoutCompat invoke() {
            return (LinearLayoutCompat) ImageSelectActivity.this.findViewById(R.id.ll_album_select);
        }
    });
    private final Lazy tvImageSelect$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$tvImageSelect$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            return (TextView) ImageSelectActivity.this.findViewById(R.id.tv_image_select);
        }
    });
    private int maxSelect = 1;

    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getSelectMode() {
            return ImageSelectActivity.selectMode;
        }

        public final void launch(BaseActivity activity, int i11, final OnPhotoSelectListener onPhotoSelectListener) {
            Intrinsics.h(activity, "activity");
            if (i11 < 1) {
                TmcLogger.d("最少要选择一个图片");
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) ImageSelectActivity.class);
            intent.putExtra(ImageSelectActivity.IMAGE_MAX_SELECT, i11);
            setSelectMode(i11 != 1 ? 2 : 1);
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, activity);
            activity.startActivityForResult(intent, new BaseActivity.OnActivityCallback() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$Companion$launch$1
                @Override // com.cloud.tmc.miniapp.base.BaseActivity.OnActivityCallback
                public void onActivityResult(int i12, Intent intent2) {
                    OnPhotoSelectListener onPhotoSelectListener2 = OnPhotoSelectListener.this;
                    if (onPhotoSelectListener2 == null) {
                        return;
                    }
                    if (intent2 == null) {
                        onPhotoSelectListener2.onCancel();
                        return;
                    }
                    ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("imageList");
                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                        OnPhotoSelectListener.this.onCancel();
                        return;
                    }
                    Iterator<String> it = stringArrayListExtra.iterator();
                    Intrinsics.g(it, "list.iterator()");
                    while (it.hasNext()) {
                        if (!new File(it.next()).isFile()) {
                            it.remove();
                        }
                    }
                    if (i12 != -1 || stringArrayListExtra.isEmpty()) {
                        OnPhotoSelectListener.this.onCancel();
                    } else {
                        OnPhotoSelectListener.this.onSelected(stringArrayListExtra);
                    }
                }
            });
        }

        public final void launch(BaseActivity activity, OnPhotoSelectListener onPhotoSelectListener) {
            Intrinsics.h(activity, "activity");
            launch(activity, 1, onPhotoSelectListener);
        }

        public final void setSelectMode(int i11) {
            ImageSelectActivity.selectMode = i11;
        }
    }

    public ImageSelectActivity() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.selectImage = arrayList;
        this.selectPosition = new ArrayList<>();
        this.allImage = new ArrayList<>();
        this.allAlbum = new ConcurrentHashMap<>();
        this.adapter = new ImageSelectAdapter(this, arrayList);
        this.tempData = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSelectTv() {
        String str;
        if (this.selectImage.isEmpty()) {
            TextView tvImageSelect = getTvImageSelect();
            if (tvImageSelect != null) {
                tvImageSelect.setText(getString(R.string.mini_image_select_done));
            }
            TextView tvImageSelect2 = getTvImageSelect();
            if (tvImageSelect2 != null) {
                tvImageSelect2.setTextColor(androidx.core.content.b.getColor(this, R.color.mini_color_505358));
                return;
            }
            return;
        }
        TextView tvImageSelect3 = getTvImageSelect();
        if (tvImageSelect3 != null) {
            if (this.maxSelect == 1) {
                str = getString(R.string.mini_image_select_done);
            } else {
                try {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                    String string = getString(R.string.mini_image_select_mutiple_done);
                    Intrinsics.g(string, "getString(R.string.mini_image_select_mutiple_done)");
                    str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(this.selectImage.size()), String.valueOf(this.maxSelect)}, 2));
                    Intrinsics.g(str, "format(format, *args)");
                } catch (Throwable unused) {
                    str = "";
                }
            }
            tvImageSelect3.setText(str);
        }
        TextView tvImageSelect4 = getTvImageSelect();
        if (tvImageSelect4 != null) {
            tvImageSelect4.setTextColor(androidx.core.content.b.getColor(this, R.color.mini_color_white));
        }
    }

    private final FrameLayout getFlTitleBack() {
        return (FrameLayout) this.flTitleBack$delegate.getValue();
    }

    private final AppCompatImageView getIvImageSelect() {
        return (AppCompatImageView) this.ivImageSelect$delegate.getValue();
    }

    private final LinearLayoutCompat getLlAlbumSelect() {
        return (LinearLayoutCompat) this.llAlbumSelect$delegate.getValue();
    }

    private final String getLocalLanguage(String str) {
        try {
            String string = StringsKt.H(str, "pictures", true) ? getString(R.string.image_select_album_pictures) : StringsKt.H(str, "screenshot", true) ? getString(R.string.image_select_album_screenshot) : StringsKt.H(str, "camera", true) ? getString(R.string.image_select_album_camera) : str;
            Intrinsics.g(string, "{\n            when {\n   …}\n            }\n        }");
            return string;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRvImageSelectList() {
        return (RecyclerView) this.rvImageSelectList$delegate.getValue();
    }

    private final StatusLayout getSlImageSelectStatus() {
        return (StatusLayout) this.slImageSelectStatus$delegate.getValue();
    }

    private final TextView getTvImageSelect() {
        return (TextView) this.tvImageSelect$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvTitle() {
        return (TextView) this.tvTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$1(ImageSelectActivity this$0) {
        Intrinsics.h(this$0, "this$0");
        try {
            this$0.run();
        } catch (Throwable unused) {
        }
    }

    private final void jumpPreviewActivity(int i11) {
        ImagePreviewActivity.Companion.launch(this, this.maxSelect, CollectionsKt.U0(this.adapter.getData()), i11, this.selectImage, this.selectPosition, new OnPhotoSelectListener() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$jumpPreviewActivity$1
            @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
            public void onAuthorized(boolean z10) {
            }

            @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
            public void onCancel() {
                OnPhotoSelectListener.DefaultImpls.onCancel(this);
            }

            @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
            public void onDialogClickCancel() {
                OnPhotoSelectListener.DefaultImpls.onDialogClickCancel(this);
            }

            @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
            public void onSelected(ArrayList<String> data) {
                Intrinsics.h(data, "data");
            }

            @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
            public void onSelected(ArrayList<String> data, ArrayList<Integer> arrayList, boolean z10) {
                ArrayList arrayList2;
                ArrayList arrayList3;
                ImageSelectAdapter imageSelectAdapter;
                ArrayList arrayList4;
                ArrayList arrayList5;
                Intrinsics.h(data, "data");
                if (z10) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("imageList", data);
                    ImageSelectActivity.this.setResult(-1, intent);
                    ImageSelectActivity.this.finish();
                    return;
                }
                arrayList2 = ImageSelectActivity.this.selectImage;
                arrayList2.clear();
                arrayList3 = ImageSelectActivity.this.selectImage;
                arrayList3.addAll(data);
                if (arrayList != null) {
                    ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                    arrayList4 = imageSelectActivity.selectPosition;
                    arrayList4.clear();
                    arrayList5 = imageSelectActivity.selectPosition;
                    arrayList5.addAll(arrayList);
                }
                ImageSelectActivity.this.changeSelectTv();
                imageSelectAdapter = ImageSelectActivity.this.adapter;
                imageSelectAdapter.notifyDataSetChanged();
            }
        });
    }

    private final void notifyImageListView() {
        try {
            post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.e
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSelectActivity.notifyImageListView$lambda$4(ImageSelectActivity.this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyImageListView$lambda$4(ImageSelectActivity this$0) {
        Intrinsics.h(this$0, "this$0");
        try {
            this$0.allImage.addAll(this$0.tempData);
            this$0.adapter.setData(this$0.allImage);
            this$0.tempData.clear();
            this$0.changeSelectTv();
            RecyclerView rvImageSelectList = this$0.getRvImageSelectList();
            if (rvImageSelectList != null) {
                rvImageSelectList.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this$0.getActivity(), R.anim.layout_fall_down));
            }
            RecyclerView rvImageSelectList2 = this$0.getRvImageSelectList();
            if (rvImageSelectList2 != null) {
                rvImageSelectList2.scheduleLayoutAnimation();
            }
            if (this$0.allImage.isEmpty()) {
                this$0.showPhotoEmpty(R.drawable.mini_ic_photo_empty, R.string.status_empty_photo, null);
            } else {
                this$0.showComplete();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$2(ImageSelectActivity this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.adapter.addData(this$0.tempData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$3(ImageSelectActivity this$0, Ref.BooleanRef finishLoad) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(finishLoad, "$finishLoad");
        if (this$0.allImage.isEmpty()) {
            finishLoad.element = true;
            this$0.notifyImageListView();
        } else {
            this$0.adapter.addData(this$0.tempData);
            this$0.tempData.clear();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R.layout.activity_image_select;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public StatusLayout getStatusLayout() {
        return getSlImageSelectStatus();
    }

    public final ArrayList<String> getTempData() {
        return this.tempData;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        TextView tvImageSelect;
        this.maxSelect = getInt(IMAGE_MAX_SELECT, this.maxSelect);
        this.adapter.setSelectMode(selectMode);
        if (this.maxSelect == 1 && (tvImageSelect = getTvImageSelect()) != null) {
            tvImageSelect.setVisibility(4);
        }
        try {
            ScheduledThreadPoolExecutor scheduledExecutor = ExecutorUtils.getScheduledExecutor();
            if (scheduledExecutor != null) {
                scheduledExecutor.execute(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageSelectActivity.initData$lambda$1(ImageSelectActivity.this);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.e("ImageSelectActivity", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        MiniBarUtils.setStatusBarNightMode(this);
        FrameLayout flTitleBack = getFlTitleBack();
        if (flTitleBack != null) {
            flTitleBack.setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        }
        AppCompatImageView ivImageSelect = getIvImageSelect();
        if (ivImageSelect != null) {
            ivImageSelect.setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        }
        setOnClickListener(getFlTitleBack(), getLlAlbumSelect(), getTvImageSelect());
        this.adapter.setOnItemClickListener(this);
        this.adapter.setOnChildClickListener(R.id.fl_image_select_check, this);
        RecyclerView rvImageSelectList = getRvImageSelectList();
        if (rvImageSelectList != null) {
            rvImageSelectList.setAdapter(this.adapter);
            rvImageSelectList.addItemDecoration(new OooO00o((int) getResources().getDimension(R.dimen.mini_dp_3)));
        }
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public boolean isLoadStatusLoadingOrError() {
        return StatusAction.DefaultImpls.isLoadStatusLoadingOrError(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1, new Intent());
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnChildClickListener
    public void onChildClick(RecyclerView recyclerView, View view, int i11) {
        int i12 = 0;
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        if (selectMode == 1) {
            jumpPreviewActivity(i11);
            return;
        }
        if (view == null || view.getId() != R.id.fl_image_select_check) {
            return;
        }
        String item = this.adapter.getItem(i11);
        if (!new File(item).isFile()) {
            this.adapter.removeItem(i11);
            String string = getResources().getString(R.string.image_select_error);
            Intrinsics.g(string, "resources.getString(R.string.image_select_error)");
            OooO.OooO0O0(string);
            return;
        }
        int indexOf = this.selectImage.indexOf(item);
        if (indexOf >= 0) {
            this.selectPosition.remove(Integer.valueOf(i11));
            this.selectImage.remove(item);
            changeSelectTv();
            this.adapter.notifyItemChanged(i11);
            for (Object obj : this.selectPosition) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.u();
                }
                int intValue = ((Number) obj).intValue();
                if (i12 >= indexOf) {
                    this.adapter.notifyItemChanged(intValue);
                }
                i12 = i13;
            }
            return;
        }
        if (this.selectImage.size() < this.maxSelect) {
            if (this.selectImage.size() < this.maxSelect) {
                this.selectImage.add(item);
                this.selectPosition.add(Integer.valueOf(i11));
                changeSelectTv();
            }
            this.adapter.notifyItemChanged(i11);
            return;
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String string2 = getResources().getString(R.string.image_select_max_hint);
            Intrinsics.g(string2, "resources.getString(R.st…ng.image_select_max_hint)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.maxSelect)}, 1));
            Intrinsics.g(format, "format(format, *args)");
            OooO.OooO00o(format);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        int i11 = 0;
        Intrinsics.h(view, "view");
        super.onClick(view);
        if (Intrinsics.c(view, getTvImageSelect())) {
            ArrayList<String> arrayList = this.selectImage;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            setResult(-1, new Intent().putStringArrayListExtra(IMAGE_SELECT_LIST, this.selectImage));
            finish();
            return;
        }
        if (Intrinsics.c(view, getFlTitleBack())) {
            setResult(-1, new Intent());
            finish();
            return;
        }
        if (!Intrinsics.c(view, getLlAlbumSelect()) || this.allImage.isEmpty()) {
            return;
        }
        ArrayList data = new ArrayList(this.allAlbum.size() + 1);
        Set<String> keySet = this.allAlbum.keySet();
        Intrinsics.g(keySet, "allAlbum.keys");
        int i12 = 0;
        for (String str : keySet) {
            List<String> list = this.allAlbum.get(str);
            if (list != null && !list.isEmpty()) {
                i12 += list.size();
                String str2 = list.get(0);
                String localLanguage = getLocalLanguage(str);
                StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                String string = getString(R.string.image_select_total);
                Intrinsics.g(string, "getString(R.string.image_select_total)");
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(list.size())}, 1));
                Intrinsics.g(format, "format(format, *args)");
                data.add(new o00Oo0(str2, localLanguage, str, format, this.adapter.getData() == list));
            }
        }
        String str3 = this.allImage.get(0);
        Intrinsics.g(str3, "allImage[0]");
        String str4 = str3;
        String string2 = getString(R.string.image_select_all);
        Intrinsics.g(string2, "getString(R.string.image_select_all)");
        String string3 = getString(R.string.image_select_all);
        Intrinsics.g(string3, "getString(R.string.image_select_all)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
        String string4 = getString(R.string.image_select_total);
        Intrinsics.g(string4, "getString(R.string.image_select_total)");
        String format2 = String.format(string4, Arrays.copyOf(new Object[]{String.valueOf(i12)}, 1));
        Intrinsics.g(format2, "format(format, *args)");
        data.add(0, new o00Oo0(str4, string2, string3, format2, this.adapter.getData() == this.allImage));
        if (this.albumDialog == null) {
            o00Ooo o00ooo = new o00Ooo(this);
            o00ooo.OooO00o = new oo000o() { // from class: com.cloud.tmc.miniapp.ui.ImageSelectActivity$onClick$1
                @Override // com.cloud.tmc.miniapp.dialog.oo000o
                public void onSelected(OooO0O0 oooO0O0, int i13, o00Oo0 bean) {
                    TextView tvTitle;
                    RecyclerView rvImageSelectList;
                    ImageSelectAdapter imageSelectAdapter;
                    ConcurrentHashMap concurrentHashMap;
                    RecyclerView rvImageSelectList2;
                    RecyclerView rvImageSelectList3;
                    ImageSelectAdapter imageSelectAdapter2;
                    ArrayList arrayList2;
                    Intrinsics.h(bean, "bean");
                    tvTitle = ImageSelectActivity.this.getTvTitle();
                    if (tvTitle != null) {
                        tvTitle.setText(bean.OooO0O0);
                    }
                    rvImageSelectList = ImageSelectActivity.this.getRvImageSelectList();
                    if (rvImageSelectList != null) {
                        rvImageSelectList.scrollToPosition(0);
                    }
                    if (i13 == 0) {
                        imageSelectAdapter2 = ImageSelectActivity.this.adapter;
                        arrayList2 = ImageSelectActivity.this.allImage;
                        imageSelectAdapter2.setData(arrayList2);
                    } else {
                        imageSelectAdapter = ImageSelectActivity.this.adapter;
                        concurrentHashMap = ImageSelectActivity.this.allAlbum;
                        imageSelectAdapter.setData((List) concurrentHashMap.get(bean.OooO0OO));
                    }
                    rvImageSelectList2 = ImageSelectActivity.this.getRvImageSelectList();
                    if (rvImageSelectList2 != null) {
                        rvImageSelectList2.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(ImageSelectActivity.this.getActivity(), R.anim.layout_from_right));
                    }
                    rvImageSelectList3 = ImageSelectActivity.this.getRvImageSelectList();
                    if (rvImageSelectList3 != null) {
                        rvImageSelectList3.scheduleLayoutAnimation();
                    }
                }
            };
            this.albumDialog = o00ooo;
        }
        o00Ooo o00ooo2 = this.albumDialog;
        if (o00ooo2 != null) {
            Intrinsics.h(data, "data");
            o00ooo2.OooO0OO.setData(data);
            int size = data.size();
            while (true) {
                if (i11 >= size) {
                    break;
                }
                if (((o00Oo0) data.get(i11)).OooO0o0) {
                    RecyclerView recyclerView = (RecyclerView) o00ooo2.OooO0O0.getValue();
                    if (recyclerView != null) {
                        recyclerView.scrollToPosition(i11);
                    }
                } else {
                    i11++;
                }
            }
            o00ooo2.show();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnItemClickListener
    public void onItemClick(RecyclerView recyclerView, View view, int i11) {
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        jumpPreviewActivity(i11);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        Iterator<String> it = this.selectImage.iterator();
        Intrinsics.g(it, "selectImage.iterator()");
        while (it.hasNext()) {
            String next = it.next();
            File file = new File(next);
            if (!file.isFile()) {
                it.remove();
                this.allImage.remove(next);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    List<String> list = this.allAlbum.get(parentFile.getName());
                    if (list != null) {
                        list.remove(next);
                    }
                    this.adapter.notifyDataSetChanged();
                    changeSelectTv();
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        File parentFile;
        try {
            this.allAlbum.clear();
            this.allImage.clear();
            Uri contentUri = MediaStore.Files.getContentUri("external");
            Intrinsics.g(contentUri, "getContentUri(\"external\")");
            ContentResolver contentResolver = getContentResolver();
            Intrinsics.g(contentResolver, "contentResolver");
            Cursor query = contentResolver.query(contentUri, new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "width", "height", "_size"}, "(media_type=?) AND _size>0", new String[]{"1"}, "date_modified DESC");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (query != null && query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("_data");
                int columnIndex2 = query.getColumnIndex("mime_type");
                int columnIndex3 = query.getColumnIndex("_size");
                int i11 = 0;
                do {
                    if (query.getLong(columnIndex3) >= 1024) {
                        String string = query.getString(columnIndex2);
                        Intrinsics.g(string, "cursor.getString(mimeTypeIndex)");
                        String string2 = query.getString(columnIndex);
                        Intrinsics.g(string2, "cursor.getString(pathIndex)");
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                            File file = new File(string2);
                            if (file.exists() && file.isFile() && (parentFile = file.getParentFile()) != null) {
                                String name = parentFile.getName();
                                Intrinsics.g(name, "parentFile.name");
                                List<String> list = this.allAlbum.get(name);
                                if (list == null) {
                                    list = new ArrayList<>();
                                    this.allAlbum.put(name, list);
                                }
                                list.add(string2);
                                this.tempData.add(string2);
                                i11++;
                                if (i11 == 50) {
                                    booleanRef.element = true;
                                    notifyImageListView();
                                } else if (i11 % 100 == 0) {
                                    post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.c
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            ImageSelectActivity.run$lambda$2(ImageSelectActivity.this);
                                        }
                                    });
                                    this.tempData.clear();
                                }
                            }
                        }
                    }
                } while (query.moveToNext());
                query.close();
            }
            if (!this.tempData.isEmpty()) {
                post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageSelectActivity.run$lambda$3(ImageSelectActivity.this, booleanRef);
                    }
                });
            }
            if (booleanRef.element) {
                return;
            }
            notifyImageListView();
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel loadingAnimationModel) {
        StatusAction.DefaultImpls.setLoadingProgressConfig(this, loadingAnimationModel);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public boolean showComplete() {
        return StatusAction.DefaultImpls.showComplete(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showCustomErrorLayout(String str, String str2, String str3, StatusLayout.OooO0O0 oooO0O0, String str4, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showCustomErrorLayout(this, str, str2, str3, oooO0O0, str4, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showError(StatusLayout.OooO0O0 oooO0O0, int i11, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showError(this, oooO0O0, i11, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(int i11, int i12, int i13, StatusLayout.OooO0O0 oooO0O0, boolean z10, boolean z11, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, i11, i12, i13, oooO0O0, z10, z11, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(int i11, int i12, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, i11, i12, oooO0O0, str, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, drawable, charSequence, oooO0O0, str, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.OooO0O0 oooO0O0, String str, boolean z10, boolean z11, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, drawable, charSequence, charSequence2, oooO0O0, str, z10, z11, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showLoading() {
        StatusAction.DefaultImpls.showLoading(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showLoadingLogo(String str, String str2) {
        StatusAction.DefaultImpls.showLoadingLogo(this, str, str2);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showMainLayoutAlpha(float f11) {
        StatusAction.DefaultImpls.showMainLayoutAlpha(this, f11);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showNoNetwork(StatusLayout.OooO0O0 oooO0O0, int i11, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showNoNetwork(this, oooO0O0, i11, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showPhotoEmpty(int i11, int i12, StatusLayout.OooO0O0 oooO0O0) {
        StatusAction.DefaultImpls.showPhotoEmpty(this, i11, i12, oooO0O0);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showUnstableNetwork(StatusLayout.OooO0O0 oooO0O0, int i11, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showUnstableNetwork(this, oooO0O0, i11, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        StatusAction.DefaultImpls.statusLayoutCreateShortCutsSuccess(this, str, function3);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutOnResume() {
        StatusAction.DefaultImpls.statusLayoutOnResume(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void updateStepAnimation(LoadStepAction loadStepAction) {
        StatusAction.DefaultImpls.updateStepAnimation(this, loadStepAction);
    }
}
