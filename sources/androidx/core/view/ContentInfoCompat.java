package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import com.cloud.tmc.integration.event.EventConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final f mCompat;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final c mBuilderCompat;

        public Builder(ClipData clipData, int i11) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(clipData, i11);
            } else {
                this.mBuilderCompat = new d(clipData, i11);
            }
        }

        public Builder(ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(contentInfoCompat);
            } else {
                this.mBuilderCompat = new d(contentInfoCompat);
            }
        }

        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        public Builder setClip(ClipData clipData) {
            this.mBuilderCompat.c(clipData);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mBuilderCompat.setExtras(bundle);
            return this;
        }

        public Builder setFlags(int i11) {
            this.mBuilderCompat.d(i11);
            return this;
        }

        public Builder setLinkUri(Uri uri) {
            this.mBuilderCompat.b(uri);
            return this;
        }

        public Builder setSource(int i11) {
            this.mBuilderCompat.a(i11);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Source {
    }

    /* loaded from: classes.dex */
    private static final class a {
        public static Pair a(ContentInfo contentInfo, final Predicate predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() != 1) {
                Objects.requireNonNull(predicate);
                Pair<ClipData, ClipData> partition = ContentInfoCompat.partition(clip, new androidx.core.util.j() { // from class: androidx.core.view.b
                    @Override // androidx.core.util.j
                    public final boolean a(Object obj) {
                        return predicate.test((ClipData.Item) obj);
                    }
                });
                return partition.first == null ? Pair.create(null, contentInfo) : partition.second == null ? Pair.create(contentInfo, null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.second).build());
            }
            boolean test = predicate.test(clip.getItemAt(0));
            ContentInfo contentInfo2 = test ? contentInfo : null;
            if (test) {
                contentInfo = null;
            }
            return Pair.create(contentInfo2, contentInfo);
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f8357a;

        b(ClipData clipData, int i11) {
            this.f8357a = i.a(clipData, i11);
        }

        b(ContentInfoCompat contentInfoCompat) {
            k.a();
            this.f8357a = j.a(contentInfoCompat.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(int i11) {
            this.f8357a.setSource(i11);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void b(Uri uri) {
            this.f8357a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public ContentInfoCompat build() {
            ContentInfo build;
            build = this.f8357a.build();
            return new ContentInfoCompat(new e(build));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void c(ClipData clipData) {
            this.f8357a.setClip(clipData);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void d(int i11) {
            this.f8357a.setFlags(i11);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(Bundle bundle) {
            this.f8357a.setExtras(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        void a(int i11);

        void b(Uri uri);

        ContentInfoCompat build();

        void c(ClipData clipData);

        void d(int i11);

        void setExtras(Bundle bundle);
    }

    /* loaded from: classes.dex */
    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        ClipData f8358a;

        /* renamed from: b, reason: collision with root package name */
        int f8359b;

        /* renamed from: c, reason: collision with root package name */
        int f8360c;

        /* renamed from: d, reason: collision with root package name */
        Uri f8361d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f8362e;

        d(ClipData clipData, int i11) {
            this.f8358a = clipData;
            this.f8359b = i11;
        }

        d(ContentInfoCompat contentInfoCompat) {
            this.f8358a = contentInfoCompat.getClip();
            this.f8359b = contentInfoCompat.getSource();
            this.f8360c = contentInfoCompat.getFlags();
            this.f8361d = contentInfoCompat.getLinkUri();
            this.f8362e = contentInfoCompat.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(int i11) {
            this.f8359b = i11;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void b(Uri uri) {
            this.f8361d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new g(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void c(ClipData clipData) {
            this.f8358a = clipData;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void d(int i11) {
            this.f8360c = i11;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(Bundle bundle) {
            this.f8362e = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo f8363a;

        e(ContentInfo contentInfo) {
            this.f8363a = androidx.core.view.a.a(androidx.core.util.i.g(contentInfo));
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int a() {
            int source;
            source = this.f8363a.getSource();
            return source;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public Uri b() {
            Uri linkUri;
            linkUri = this.f8363a.getLinkUri();
            return linkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public ContentInfo c() {
            return this.f8363a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public ClipData d() {
            ClipData clip;
            clip = this.f8363a.getClip();
            return clip;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public Bundle getExtras() {
            Bundle extras;
            extras = this.f8363a.getExtras();
            return extras;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            int flags;
            flags = this.f8363a.getFlags();
            return flags;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f8363a + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface f {
        int a();

        Uri b();

        ContentInfo c();

        ClipData d();

        Bundle getExtras();

        int getFlags();
    }

    /* loaded from: classes.dex */
    private static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ClipData f8364a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8365b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8366c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f8367d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f8368e;

        g(d dVar) {
            this.f8364a = (ClipData) androidx.core.util.i.g(dVar.f8358a);
            this.f8365b = androidx.core.util.i.c(dVar.f8359b, 0, 5, EventConstants.KEY_SOURCE);
            this.f8366c = androidx.core.util.i.f(dVar.f8360c, 1);
            this.f8367d = dVar.f8361d;
            this.f8368e = dVar.f8362e;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int a() {
            return this.f8365b;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public Uri b() {
            return this.f8367d;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public ClipData d() {
            return this.f8364a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public Bundle getExtras() {
            return this.f8368e;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            return this.f8366c;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f8364a.getDescription());
            sb2.append(", source=");
            sb2.append(ContentInfoCompat.sourceToString(this.f8365b));
            sb2.append(", flags=");
            sb2.append(ContentInfoCompat.flagsToString(this.f8366c));
            if (this.f8367d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f8367d.toString().length() + ")";
            }
            sb2.append(str);
            sb2.append(this.f8368e != null ? ", hasExtras" : "");
            sb2.append("}");
            return sb2.toString();
        }
    }

    ContentInfoCompat(f fVar) {
        this.mCompat = fVar;
    }

    static ClipData buildClipData(ClipDescription clipDescription, List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i11 = 1; i11 < list.size(); i11++) {
            clipData.addItem(list.get(i11));
        }
        return clipData;
    }

    static String flagsToString(int i11) {
        return (i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11);
    }

    static Pair<ClipData, ClipData> partition(ClipData clipData, androidx.core.util.j jVar) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i11 = 0; i11 < clipData.getItemCount(); i11++) {
            ClipData.Item itemAt = clipData.getItemAt(i11);
            if (jVar.a(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        return arrayList == null ? Pair.create(null, clipData) : arrayList2 == null ? Pair.create(clipData, null) : Pair.create(buildClipData(clipData.getDescription(), arrayList), buildClipData(clipData.getDescription(), arrayList2));
    }

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo contentInfo, Predicate<ClipData.Item> predicate) {
        return a.a(contentInfo, predicate);
    }

    static String sourceToString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? String.valueOf(i11) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo contentInfo) {
        return new ContentInfoCompat(new e(contentInfo));
    }

    public ClipData getClip() {
        return this.mCompat.d();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.b();
    }

    public int getSource() {
        return this.mCompat.a();
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.j jVar) {
        ClipData d11 = this.mCompat.d();
        if (d11.getItemCount() == 1) {
            boolean a11 = jVar.a(d11.getItemAt(0));
            return Pair.create(a11 ? this : null, a11 ? null : this);
        }
        Pair<ClipData, ClipData> partition = partition(d11, jVar);
        return partition.first == null ? Pair.create(null, this) : partition.second == null ? Pair.create(this, null) : Pair.create(new Builder(this).setClip((ClipData) partition.first).build(), new Builder(this).setClip((ClipData) partition.second).build());
    }

    public ContentInfo toContentInfo() {
        ContentInfo c11 = this.mCompat.c();
        Objects.requireNonNull(c11);
        return androidx.core.view.a.a(c11);
    }

    public String toString() {
        return this.mCompat.toString();
    }
}
