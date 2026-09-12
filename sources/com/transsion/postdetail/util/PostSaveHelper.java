package com.transsion.postdetail.util;

import android.app.Application;
import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class PostSaveHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final PostSaveHelper f50199a = new PostSaveHelper();

    /* loaded from: classes6.dex */
    public static final class a implements RequestListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f50200a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Image f50201b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f50202c;

        a(Ref.IntRef intRef, Image image, Ref.ObjectRef objectRef) {
            this.f50200a = intRef;
            this.f50201b = image;
            this.f50202c = objectRef;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(File resource, Object model, Target target, DataSource dataSource, boolean z10) {
            Intrinsics.h(resource, "resource");
            Intrinsics.h(model, "model");
            Intrinsics.h(target, "target");
            Intrinsics.h(dataSource, "dataSource");
            this.f50200a.element++;
            PostSaveHelper.f50199a.f(resource, this.f50201b.getUrl(), this.f50200a.element == ((List) this.f50202c.element).size());
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            Intrinsics.h(target, "target");
            uh.b.f76876a.d(R$string.download_failed);
            return false;
        }
    }

    private PostSaveHelper() {
    }

    private final String d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = (String[]) StringsKt.S0(str, new String[]{"[?]"}, false, 0, 6, null).toArray(new String[0]);
        if (!(strArr.length == 0)) {
            String[] strArr2 = (String[]) StringsKt.S0(strArr[0], new String[]{"/"}, false, 0, 6, null).toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return System.currentTimeMillis() + "_" + strArr2[strArr2.length - 1];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(File file, String str, boolean z10) {
        String d11 = d(str);
        if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), GifImagePreviewActivity.PICTURE_SAVE + File.separator + d11).exists()) {
            uh.b.f76876a.d(R$string.has_been_saved);
            return;
        }
        if (file == null || d11 == null) {
            return;
        }
        FileHelper fileHelper = FileHelper.f47736a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        fileHelper.f(file, a11, d11, GifImagePreviewActivity.PICTURE_SAVE, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(PostSubjectItem postSubjectItem) {
        Media media;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        uh.b.f76876a.d(com.transsion.baseui.R$string.post_start_saving);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? 0 : media.getImage();
        Ref.IntRef intRef = new Ref.IntRef();
        List<Image> list = (List) objectRef.element;
        if (list != null) {
            for (Image image : list) {
                Glide.with(Utils.a()).downloadOnly().load2(image.getUrl()).listener(new a(intRef, image, objectRef)).preload();
            }
        }
    }

    public final void c(PostSubjectItem postSubjectItem) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new PostSaveHelper$downloadVideo$1(postSubjectItem, null), 3, null);
    }

    public final void e(PostSubjectItem postSubjectItem) {
        Media media;
        Media media2;
        Media media3;
        String str = null;
        if (Intrinsics.c((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getMediaType(), MediaType.VIDEO.getValue())) {
            c(postSubjectItem);
            return;
        }
        if (!Intrinsics.c((postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null) ? null : media2.getMediaType(), MediaType.IMAGE.getValue())) {
            if (postSubjectItem != null && (media = postSubjectItem.getMedia()) != null) {
                str = media.getMediaType();
            }
            if (!Intrinsics.c(str, MediaType.IMAGE_SINGLE.getValue())) {
                return;
            }
        }
        b(postSubjectItem);
    }
}
