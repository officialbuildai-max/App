package mu;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes7.dex */
public final class i implements mu.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f70129a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f70130b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f70131c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f70132d = new c();

    /* loaded from: classes7.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `st_download_table` (`id`,`resourceStreamType`,`resourceId`,`lan`,`lanName`,`url`,`size`,`delay`,`downloads`,`type`,`postId`,`subtitleName`,`subjectId`,`ep`,`se`,`resolution`,`subjectName`,`status`,`fileCharsetName`,`path`,`zipPath`,`taskId`,`failCount`,`ugcVideoId`,`ugcVideoCollectionId`,`ops`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleDownloadTable.getDownloads().intValue());
            }
            eVar.c(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, subtitleDownloadTable.getSubjectId());
            }
            eVar.c(14, subtitleDownloadTable.getEp());
            eVar.c(15, subtitleDownloadTable.getSe());
            eVar.c(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, subtitleDownloadTable.getSubjectName());
            }
            eVar.c(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, subtitleDownloadTable.getTaskId());
            }
            eVar.c(23, subtitleDownloadTable.getFailCount());
            if (subtitleDownloadTable.getUgcVideoId() == null) {
                eVar.g(24);
            } else {
                eVar.j(24, subtitleDownloadTable.getUgcVideoId());
            }
            if (subtitleDownloadTable.getUgcVideoCollectionId() == null) {
                eVar.g(25);
            } else {
                eVar.j(25, subtitleDownloadTable.getUgcVideoCollectionId());
            }
            if (subtitleDownloadTable.getOps() == null) {
                eVar.g(26);
            } else {
                eVar.j(26, subtitleDownloadTable.getOps());
            }
        }
    }

    /* loaded from: classes7.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `st_download_table` WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
        }
    }

    /* loaded from: classes7.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `st_download_table` SET `id` = ?,`resourceStreamType` = ?,`resourceId` = ?,`lan` = ?,`lanName` = ?,`url` = ?,`size` = ?,`delay` = ?,`downloads` = ?,`type` = ?,`postId` = ?,`subtitleName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`subjectName` = ?,`status` = ?,`fileCharsetName` = ?,`path` = ?,`zipPath` = ?,`taskId` = ?,`failCount` = ?,`ugcVideoId` = ?,`ugcVideoCollectionId` = ?,`ops` = ? WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleDownloadTable.getDownloads().intValue());
            }
            eVar.c(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, subtitleDownloadTable.getSubjectId());
            }
            eVar.c(14, subtitleDownloadTable.getEp());
            eVar.c(15, subtitleDownloadTable.getSe());
            eVar.c(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, subtitleDownloadTable.getSubjectName());
            }
            eVar.c(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, subtitleDownloadTable.getTaskId());
            }
            eVar.c(23, subtitleDownloadTable.getFailCount());
            if (subtitleDownloadTable.getUgcVideoId() == null) {
                eVar.g(24);
            } else {
                eVar.j(24, subtitleDownloadTable.getUgcVideoId());
            }
            if (subtitleDownloadTable.getUgcVideoCollectionId() == null) {
                eVar.g(25);
            } else {
                eVar.j(25, subtitleDownloadTable.getUgcVideoCollectionId());
            }
            if (subtitleDownloadTable.getOps() == null) {
                eVar.g(26);
            } else {
                eVar.j(26, subtitleDownloadTable.getOps());
            }
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(27);
            } else {
                eVar.j(27, subtitleDownloadTable.getId());
            }
            eVar.c(28, subtitleDownloadTable.getResourceStreamType());
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f70129a = roomDatabase;
    }

    public static List o() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(SubtitleDownloadTable subtitleDownloadTable, z3.b bVar) {
        this.f70131c.c(bVar, subtitleDownloadTable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit q(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM st_download_table WHERE resourceId =?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List r(int i11, z3.b bVar) {
        ArrayList arrayList;
        String n02;
        int i12;
        int i13;
        int i14;
        Integer valueOf;
        String n03;
        int i15;
        int i16;
        int i17;
        String n04;
        int i18;
        int i19;
        String n05;
        int i20;
        int i21;
        String n06;
        int i22;
        String n07;
        int i23;
        int i24;
        String n08;
        int i25;
        String n09;
        int i26;
        int i27;
        String n010;
        int i28;
        z3.e D0 = bVar.D0("SELECT * FROM st_download_table WHERE status = ?");
        try {
            D0.c(1, i11);
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "resourceStreamType");
            int d13 = k.d(D0, "resourceId");
            int d14 = k.d(D0, "lan");
            int d15 = k.d(D0, "lanName");
            int d16 = k.d(D0, "url");
            int d17 = k.d(D0, "size");
            int d18 = k.d(D0, "delay");
            int d19 = k.d(D0, "downloads");
            int d20 = k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = k.d(D0, "postId");
            int d22 = k.d(D0, "subtitleName");
            int d23 = k.d(D0, "subjectId");
            int d24 = k.d(D0, "ep");
            int d25 = k.d(D0, "se");
            int d26 = k.d(D0, "resolution");
            int d27 = k.d(D0, "subjectName");
            int d28 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d29 = k.d(D0, "fileCharsetName");
            int d30 = k.d(D0, "path");
            int d31 = k.d(D0, "zipPath");
            int d32 = k.d(D0, "taskId");
            int d33 = k.d(D0, "failCount");
            int d34 = k.d(D0, "ugcVideoId");
            int d35 = k.d(D0, "ugcVideoCollectionId");
            int d36 = k.d(D0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (D0.A0()) {
                if (D0.isNull(d11)) {
                    i12 = d24;
                    arrayList = arrayList2;
                    n02 = null;
                } else {
                    arrayList = arrayList2;
                    n02 = D0.n0(d11);
                    i12 = d24;
                }
                int i29 = (int) D0.getLong(d12);
                String n011 = D0.isNull(d13) ? null : D0.n0(d13);
                String n012 = D0.isNull(d14) ? null : D0.n0(d14);
                String n013 = D0.isNull(d15) ? null : D0.n0(d15);
                String n014 = D0.isNull(d16) ? null : D0.n0(d16);
                Long valueOf2 = D0.isNull(d17) ? null : Long.valueOf(D0.getLong(d17));
                Long valueOf3 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i13 = d12;
                    i14 = d13;
                    valueOf = null;
                } else {
                    i13 = d12;
                    i14 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                int i30 = (int) D0.getLong(d20);
                String n015 = D0.isNull(d21) ? null : D0.n0(d21);
                String n016 = D0.isNull(d22) ? null : D0.n0(d22);
                if (D0.isNull(d23)) {
                    i15 = d15;
                    i16 = i12;
                    n03 = null;
                } else {
                    n03 = D0.n0(d23);
                    i15 = d15;
                    i16 = i12;
                }
                int i31 = d14;
                int i32 = (int) D0.getLong(i16);
                int i33 = d25;
                int i34 = d16;
                int i35 = d17;
                int i36 = (int) D0.getLong(i33);
                int i37 = d26;
                int i38 = d18;
                int i39 = d19;
                int i40 = (int) D0.getLong(i37);
                int i41 = d27;
                if (D0.isNull(i41)) {
                    i18 = d11;
                    i17 = i41;
                    i19 = d28;
                    n04 = null;
                } else {
                    i17 = i41;
                    n04 = D0.n0(i41);
                    i18 = d11;
                    i19 = d28;
                }
                int i42 = d20;
                int i43 = (int) D0.getLong(i19);
                int i44 = d29;
                if (D0.isNull(i44)) {
                    i20 = i19;
                    i21 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i44);
                    i20 = i19;
                    i21 = d30;
                }
                if (D0.isNull(i21)) {
                    d30 = i21;
                    i22 = d31;
                    n06 = null;
                } else {
                    n06 = D0.n0(i21);
                    d30 = i21;
                    i22 = d31;
                }
                if (D0.isNull(i22)) {
                    d31 = i22;
                    i23 = d32;
                    n07 = null;
                } else {
                    n07 = D0.n0(i22);
                    d31 = i22;
                    i23 = d32;
                }
                if (D0.isNull(i23)) {
                    d32 = i23;
                    i24 = i44;
                    i25 = d33;
                    n08 = null;
                } else {
                    i24 = i44;
                    n08 = D0.n0(i23);
                    d32 = i23;
                    i25 = d33;
                }
                int i45 = d21;
                int i46 = (int) D0.getLong(i25);
                int i47 = d34;
                if (D0.isNull(i47)) {
                    i26 = i25;
                    i27 = d35;
                    n09 = null;
                } else {
                    n09 = D0.n0(i47);
                    i26 = i25;
                    i27 = d35;
                }
                if (D0.isNull(i27)) {
                    d35 = i27;
                    i28 = d36;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    d35 = i27;
                    i28 = d36;
                }
                d36 = i28;
                SubtitleDownloadTable subtitleDownloadTable = new SubtitleDownloadTable(n02, i29, n011, n012, n013, n014, valueOf2, valueOf3, valueOf, i30, n015, n016, n03, i32, i36, i40, n04, i43, n05, n06, n07, n08, i46, n09, n010, D0.isNull(i28) ? null : D0.n0(i28));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(subtitleDownloadTable);
                d16 = i34;
                d18 = i38;
                d24 = i16;
                d25 = i33;
                d26 = i37;
                d11 = i18;
                d20 = i42;
                d28 = i20;
                d14 = i31;
                d13 = i14;
                d15 = i15;
                d17 = i35;
                d19 = i39;
                d27 = i17;
                d29 = i24;
                int i48 = i13;
                arrayList2 = arrayList3;
                d12 = i48;
                int i49 = i26;
                d34 = i47;
                d21 = i45;
                d33 = i49;
            }
            return arrayList2;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List s(String str, z3.b bVar) {
        ArrayList arrayList;
        String n02;
        int i11;
        int i12;
        int i13;
        Integer valueOf;
        String n03;
        int i14;
        int i15;
        int i16;
        String n04;
        int i17;
        int i18;
        String n05;
        int i19;
        int i20;
        String n06;
        int i21;
        String n07;
        int i22;
        int i23;
        String n08;
        int i24;
        String n09;
        int i25;
        int i26;
        String n010;
        int i27;
        z3.e D0 = bVar.D0("SELECT * FROM st_download_table WHERE resourceId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "resourceStreamType");
            int d13 = k.d(D0, "resourceId");
            int d14 = k.d(D0, "lan");
            int d15 = k.d(D0, "lanName");
            int d16 = k.d(D0, "url");
            int d17 = k.d(D0, "size");
            int d18 = k.d(D0, "delay");
            int d19 = k.d(D0, "downloads");
            int d20 = k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = k.d(D0, "postId");
            int d22 = k.d(D0, "subtitleName");
            int d23 = k.d(D0, "subjectId");
            int d24 = k.d(D0, "ep");
            int d25 = k.d(D0, "se");
            int d26 = k.d(D0, "resolution");
            int d27 = k.d(D0, "subjectName");
            int d28 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d29 = k.d(D0, "fileCharsetName");
            int d30 = k.d(D0, "path");
            int d31 = k.d(D0, "zipPath");
            int d32 = k.d(D0, "taskId");
            int d33 = k.d(D0, "failCount");
            int d34 = k.d(D0, "ugcVideoId");
            int d35 = k.d(D0, "ugcVideoCollectionId");
            int d36 = k.d(D0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (D0.A0()) {
                if (D0.isNull(d11)) {
                    i11 = d24;
                    arrayList = arrayList2;
                    n02 = null;
                } else {
                    arrayList = arrayList2;
                    n02 = D0.n0(d11);
                    i11 = d24;
                }
                int i28 = (int) D0.getLong(d12);
                String n011 = D0.isNull(d13) ? null : D0.n0(d13);
                String n012 = D0.isNull(d14) ? null : D0.n0(d14);
                String n013 = D0.isNull(d15) ? null : D0.n0(d15);
                String n014 = D0.isNull(d16) ? null : D0.n0(d16);
                Long valueOf2 = D0.isNull(d17) ? null : Long.valueOf(D0.getLong(d17));
                Long valueOf3 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i12 = d12;
                    i13 = d13;
                    valueOf = null;
                } else {
                    i12 = d12;
                    i13 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                int i29 = (int) D0.getLong(d20);
                String n015 = D0.isNull(d21) ? null : D0.n0(d21);
                String n016 = D0.isNull(d22) ? null : D0.n0(d22);
                if (D0.isNull(d23)) {
                    i14 = d15;
                    i15 = i11;
                    n03 = null;
                } else {
                    n03 = D0.n0(d23);
                    i14 = d15;
                    i15 = i11;
                }
                int i30 = d14;
                int i31 = (int) D0.getLong(i15);
                int i32 = d25;
                int i33 = d16;
                int i34 = d17;
                int i35 = (int) D0.getLong(i32);
                int i36 = d26;
                int i37 = d18;
                int i38 = d19;
                int i39 = (int) D0.getLong(i36);
                int i40 = d27;
                if (D0.isNull(i40)) {
                    i17 = d11;
                    i16 = i40;
                    i18 = d28;
                    n04 = null;
                } else {
                    i16 = i40;
                    n04 = D0.n0(i40);
                    i17 = d11;
                    i18 = d28;
                }
                int i41 = d20;
                int i42 = (int) D0.getLong(i18);
                int i43 = d29;
                if (D0.isNull(i43)) {
                    i19 = i18;
                    i20 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i43);
                    i19 = i18;
                    i20 = d30;
                }
                if (D0.isNull(i20)) {
                    d30 = i20;
                    i21 = d31;
                    n06 = null;
                } else {
                    n06 = D0.n0(i20);
                    d30 = i20;
                    i21 = d31;
                }
                if (D0.isNull(i21)) {
                    d31 = i21;
                    i22 = d32;
                    n07 = null;
                } else {
                    n07 = D0.n0(i21);
                    d31 = i21;
                    i22 = d32;
                }
                if (D0.isNull(i22)) {
                    d32 = i22;
                    i23 = i43;
                    i24 = d33;
                    n08 = null;
                } else {
                    i23 = i43;
                    n08 = D0.n0(i22);
                    d32 = i22;
                    i24 = d33;
                }
                int i44 = d21;
                int i45 = (int) D0.getLong(i24);
                int i46 = d34;
                if (D0.isNull(i46)) {
                    i25 = i24;
                    i26 = d35;
                    n09 = null;
                } else {
                    n09 = D0.n0(i46);
                    i25 = i24;
                    i26 = d35;
                }
                if (D0.isNull(i26)) {
                    d35 = i26;
                    i27 = d36;
                    n010 = null;
                } else {
                    n010 = D0.n0(i26);
                    d35 = i26;
                    i27 = d36;
                }
                d36 = i27;
                SubtitleDownloadTable subtitleDownloadTable = new SubtitleDownloadTable(n02, i28, n011, n012, n013, n014, valueOf2, valueOf3, valueOf, i29, n015, n016, n03, i31, i35, i39, n04, i42, n05, n06, n07, n08, i45, n09, n010, D0.isNull(i27) ? null : D0.n0(i27));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(subtitleDownloadTable);
                d16 = i33;
                d18 = i37;
                d24 = i15;
                d25 = i32;
                d26 = i36;
                d11 = i17;
                d20 = i41;
                d28 = i19;
                d14 = i30;
                d13 = i13;
                d15 = i14;
                d17 = i34;
                d19 = i38;
                d27 = i16;
                d29 = i23;
                int i47 = i12;
                arrayList2 = arrayList3;
                d12 = i47;
                int i48 = i25;
                d34 = i46;
                d21 = i44;
                d33 = i48;
            }
            ArrayList arrayList4 = arrayList2;
            D0.close();
            return arrayList4;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SubtitleDownloadTable t(String str, int i11, z3.b bVar) {
        String n02;
        int i12;
        int i13;
        String n03;
        int i14;
        String n04;
        int i15;
        String n05;
        int i16;
        String n06;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        z3.e D0 = bVar.D0("SELECT * FROM st_download_table WHERE id = ? AND resourceStreamType = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "resourceStreamType");
            int d13 = k.d(D0, "resourceId");
            int d14 = k.d(D0, "lan");
            int d15 = k.d(D0, "lanName");
            int d16 = k.d(D0, "url");
            int d17 = k.d(D0, "size");
            int d18 = k.d(D0, "delay");
            int d19 = k.d(D0, "downloads");
            int d20 = k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = k.d(D0, "postId");
            int d22 = k.d(D0, "subtitleName");
            int d23 = k.d(D0, "subjectId");
            int d24 = k.d(D0, "ep");
            int d25 = k.d(D0, "se");
            int d26 = k.d(D0, "resolution");
            int d27 = k.d(D0, "subjectName");
            int d28 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d29 = k.d(D0, "fileCharsetName");
            int d30 = k.d(D0, "path");
            int d31 = k.d(D0, "zipPath");
            int d32 = k.d(D0, "taskId");
            int d33 = k.d(D0, "failCount");
            int d34 = k.d(D0, "ugcVideoId");
            int d35 = k.d(D0, "ugcVideoCollectionId");
            int d36 = k.d(D0, "ops");
            SubtitleDownloadTable subtitleDownloadTable = null;
            if (D0.A0()) {
                if (D0.isNull(d11)) {
                    i12 = d24;
                    i13 = d36;
                    n02 = null;
                } else {
                    n02 = D0.n0(d11);
                    i12 = d24;
                    i13 = d36;
                }
                int i21 = (int) D0.getLong(d12);
                String n010 = D0.isNull(d13) ? null : D0.n0(d13);
                String n011 = D0.isNull(d14) ? null : D0.n0(d14);
                String n012 = D0.isNull(d15) ? null : D0.n0(d15);
                String n013 = D0.isNull(d16) ? null : D0.n0(d16);
                Long valueOf = D0.isNull(d17) ? null : Long.valueOf(D0.getLong(d17));
                Long valueOf2 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                Integer valueOf3 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                int i22 = (int) D0.getLong(d20);
                String n014 = D0.isNull(d21) ? null : D0.n0(d21);
                String n015 = D0.isNull(d22) ? null : D0.n0(d22);
                String n016 = D0.isNull(d23) ? null : D0.n0(d23);
                int i23 = (int) D0.getLong(i12);
                int i24 = (int) D0.getLong(d25);
                int i25 = (int) D0.getLong(d26);
                if (D0.isNull(d27)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(d27);
                    i14 = d28;
                }
                int i26 = (int) D0.getLong(i14);
                if (D0.isNull(d29)) {
                    i15 = d30;
                    n04 = null;
                } else {
                    n04 = D0.n0(d29);
                    i15 = d30;
                }
                if (D0.isNull(i15)) {
                    i16 = d31;
                    n05 = null;
                } else {
                    n05 = D0.n0(i15);
                    i16 = d31;
                }
                if (D0.isNull(i16)) {
                    i17 = d32;
                    n06 = null;
                } else {
                    n06 = D0.n0(i16);
                    i17 = d32;
                }
                if (D0.isNull(i17)) {
                    i18 = d33;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    i18 = d33;
                }
                int i27 = (int) D0.getLong(i18);
                if (D0.isNull(d34)) {
                    i19 = d35;
                    n08 = null;
                } else {
                    n08 = D0.n0(d34);
                    i19 = d35;
                }
                if (D0.isNull(i19)) {
                    i20 = i13;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    i20 = i13;
                }
                subtitleDownloadTable = new SubtitleDownloadTable(n02, i21, n010, n011, n012, n013, valueOf, valueOf2, valueOf3, i22, n014, n015, n016, i23, i24, i25, n03, i26, n04, n05, n06, n07, i27, n08, n09, D0.isNull(i20) ? null : D0.n0(i20));
            }
            D0.close();
            return subtitleDownloadTable;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit u(SubtitleDownloadTable subtitleDownloadTable, z3.b bVar) {
        this.f70130b.d(bVar, subtitleDownloadTable);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v(SubtitleDownloadTable subtitleDownloadTable, z3.b bVar) {
        this.f70132d.c(bVar, subtitleDownloadTable);
        return null;
    }

    @Override // mu.a
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f70129a, true, false, new Function1() { // from class: mu.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List s11;
                s11 = i.s(str, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // mu.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f70129a, false, true, new Function1() { // from class: mu.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = i.q(str, (z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // mu.a
    public SubtitleDownloadTable c(final String str, final int i11) {
        return (SubtitleDownloadTable) androidx.room.util.b.d(this.f70129a, true, false, new Function1() { // from class: mu.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SubtitleDownloadTable t11;
                t11 = i.t(str, i11, (z3.b) obj);
                return t11;
            }
        });
    }

    @Override // mu.a
    public Object d(final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f70129a, true, false, new Function1() { // from class: mu.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List r11;
                r11 = i.r(i11, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // mu.a
    public Object e(final SubtitleDownloadTable subtitleDownloadTable, Continuation continuation) {
        subtitleDownloadTable.getClass();
        return androidx.room.util.b.f(this.f70129a, false, true, new Function1() { // from class: mu.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u11;
                u11 = i.this.u(subtitleDownloadTable, (z3.b) obj);
                return u11;
            }
        }, continuation);
    }

    @Override // mu.a
    public void f(final SubtitleDownloadTable subtitleDownloadTable) {
        subtitleDownloadTable.getClass();
        androidx.room.util.b.d(this.f70129a, false, true, new Function1() { // from class: mu.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object v11;
                v11 = i.this.v(subtitleDownloadTable, (z3.b) obj);
                return v11;
            }
        });
    }

    @Override // mu.a
    public void g(final SubtitleDownloadTable subtitleDownloadTable) {
        subtitleDownloadTable.getClass();
        androidx.room.util.b.d(this.f70129a, false, true, new Function1() { // from class: mu.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object p11;
                p11 = i.this.p(subtitleDownloadTable, (z3.b) obj);
                return p11;
            }
        });
    }
}
