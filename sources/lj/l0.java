package lj;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class l0 implements lj.c {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69030a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69031b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f69032c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f69033d = new c();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `download_table` (`url`,`resourceId`,`name`,`cover`,`size`,`postId`,`sizeFormat`,`path`,`duration`,`updateTimeStamp`,`progress`,`supportRanges`,`status`,`type`,`readProgress`,`createAt`,`isRead`,`episode`,`ep`,`se`,`resolution`,`resourcePosition`,`multiresolution`,`videoWidth`,`videoHeight`,`downloadErrorCount`,`subtitleStarted`,`subjectId`,`pageFrom`,`lastPageFrom`,`subjectName`,`lastPlayTimeStamp`,`fileType`,`totalEpisode`,`uploadBy`,`sourceUrl`,`urlCreateAt`,`subtitleSelectId`,`taskId`,`sessionTime`,`reportStatus`,`downloadHeaderSize`,`rootPath`,`rootPathType`,`thumbnail`,`averageHueLight`,`isTransferFailed`,`isClosedTransferFailed`,`subjectType`,`genre`,`subjectDurationSeconds`,`currentDubLanName`,`currentDubLanCode`,`ops`,`restrictLevel`,`releaseDate`,`countryName`,`seNum`,`subtitles`,`imdbRate`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`subtitleIdType`,`ugcVideoCollectionId`,`ugcVideoId`,`ugcVideoName`,`ugcVideoCollectionName`,`ugcVideoPosition`,`ugcVideoType`,`ugcCateLev1Id`,`ugcCateLev2Id`,`ugcCateLev3Id`,`ugcCateLev4Id`,`ugcVideoTrackId`,`ugcVideoParentVideoId`,`ugcVideoParentTrackId`,`ugcVideoEpTitle`,`ugcVideoIsVertical`,`originData`,`kidId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            eVar.c(11, downloadBean.getProgress());
            eVar.c(12, downloadBean.getSupportRanges());
            eVar.c(13, downloadBean.getStatus());
            eVar.c(14, downloadBean.getType());
            eVar.c(15, downloadBean.getReadProgress());
            eVar.c(16, downloadBean.getCreateAt());
            eVar.c(17, downloadBean.getIsRead());
            eVar.c(18, downloadBean.getEpse());
            eVar.c(19, downloadBean.getEp());
            eVar.c(20, downloadBean.getSe());
            eVar.c(21, downloadBean.getResolution());
            eVar.c(22, downloadBean.getResourcePosition());
            eVar.c(23, downloadBean.getMultiresolution());
            eVar.c(24, downloadBean.getVideoWidth());
            eVar.c(25, downloadBean.getVideoHeight());
            eVar.c(26, downloadBean.getDownloadErrorCount());
            eVar.c(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.j(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                eVar.g(29);
            } else {
                eVar.j(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, downloadBean.getSubjectName());
            }
            eVar.c(32, downloadBean.getLastPlayTimeStamp());
            eVar.c(33, downloadBean.getFileType());
            eVar.c(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                eVar.g(35);
            } else {
                eVar.j(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                eVar.g(36);
            } else {
                eVar.j(36, downloadBean.getSourceUrl());
            }
            eVar.c(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                eVar.g(38);
            } else {
                eVar.j(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                eVar.g(39);
            } else {
                eVar.j(39, downloadBean.getTaskId());
            }
            eVar.c(40, downloadBean.getSessionTime());
            eVar.c(41, downloadBean.getReportStatus());
            eVar.c(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                eVar.g(43);
            } else {
                eVar.j(43, downloadBean.getRootPath());
            }
            eVar.c(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                eVar.g(45);
            } else {
                eVar.j(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                eVar.g(46);
            } else {
                eVar.j(46, downloadBean.getAverageHueLight());
            }
            eVar.c(47, downloadBean.getIsTransferFailed() ? 1L : 0L);
            eVar.c(48, downloadBean.getIsClosedTransferFailed() ? 1L : 0L);
            eVar.c(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                eVar.g(50);
            } else {
                eVar.j(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                eVar.g(51);
            } else {
                eVar.c(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                eVar.g(52);
            } else {
                eVar.j(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                eVar.g(53);
            } else {
                eVar.j(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                eVar.g(54);
            } else {
                eVar.j(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                eVar.g(55);
            } else {
                eVar.j(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                eVar.g(56);
            } else {
                eVar.j(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                eVar.g(57);
            } else {
                eVar.j(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                eVar.g(58);
            } else {
                eVar.c(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                eVar.g(59);
            } else {
                eVar.j(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                eVar.g(60);
            } else {
                eVar.j(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                eVar.g(61);
            } else {
                eVar.c(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                eVar.g(62);
            } else {
                eVar.c(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
            if (downloadBean.getSubtitleIdType() == null) {
                eVar.g(63);
            } else {
                eVar.j(63, downloadBean.getSubtitleIdType());
            }
            if (downloadBean.getUgcVideoCollectionId() == null) {
                eVar.g(64);
            } else {
                eVar.j(64, downloadBean.getUgcVideoCollectionId());
            }
            if (downloadBean.getUgcVideoId() == null) {
                eVar.g(65);
            } else {
                eVar.j(65, downloadBean.getUgcVideoId());
            }
            if (downloadBean.getUgcVideoName() == null) {
                eVar.g(66);
            } else {
                eVar.j(66, downloadBean.getUgcVideoName());
            }
            if (downloadBean.getUgcVideoCollectionName() == null) {
                eVar.g(67);
            } else {
                eVar.j(67, downloadBean.getUgcVideoCollectionName());
            }
            if (downloadBean.getUgcVideoPosition() == null) {
                eVar.g(68);
            } else {
                eVar.c(68, downloadBean.getUgcVideoPosition().intValue());
            }
            if (downloadBean.getUgcVideoType() == null) {
                eVar.g(69);
            } else {
                eVar.j(69, downloadBean.getUgcVideoType());
            }
            if (downloadBean.getUgcCateLev1Id() == null) {
                eVar.g(70);
            } else {
                eVar.c(70, downloadBean.getUgcCateLev1Id().intValue());
            }
            if (downloadBean.getUgcCateLev2Id() == null) {
                eVar.g(71);
            } else {
                eVar.c(71, downloadBean.getUgcCateLev2Id().intValue());
            }
            if (downloadBean.getUgcCateLev3Id() == null) {
                eVar.g(72);
            } else {
                eVar.c(72, downloadBean.getUgcCateLev3Id().intValue());
            }
            if (downloadBean.getUgcCateLev4Id() == null) {
                eVar.g(73);
            } else {
                eVar.c(73, downloadBean.getUgcCateLev4Id().intValue());
            }
            if (downloadBean.getUgcVideoTrackId() == null) {
                eVar.g(74);
            } else {
                eVar.j(74, downloadBean.getUgcVideoTrackId());
            }
            if (downloadBean.getUgcVideoParentVideoId() == null) {
                eVar.g(75);
            } else {
                eVar.j(75, downloadBean.getUgcVideoParentVideoId());
            }
            if (downloadBean.getUgcVideoParentTrackId() == null) {
                eVar.g(76);
            } else {
                eVar.j(76, downloadBean.getUgcVideoParentTrackId());
            }
            if (downloadBean.getUgcVideoEpTitle() == null) {
                eVar.g(77);
            } else {
                eVar.j(77, downloadBean.getUgcVideoEpTitle());
            }
            eVar.c(78, downloadBean.getUgcVideoIsVertical() ? 1L : 0L);
            if (downloadBean.getOriginData() == null) {
                eVar.g(79);
            } else {
                eVar.j(79, downloadBean.getOriginData());
            }
            if (downloadBean.getKidId() == null) {
                eVar.g(80);
            } else {
                eVar.j(80, downloadBean.getKidId());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `download_table` WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, downloadBean.getUrl());
            }
        }
    }

    /* loaded from: classes6.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `download_table` SET `url` = ?,`resourceId` = ?,`name` = ?,`cover` = ?,`size` = ?,`postId` = ?,`sizeFormat` = ?,`path` = ?,`duration` = ?,`updateTimeStamp` = ?,`progress` = ?,`supportRanges` = ?,`status` = ?,`type` = ?,`readProgress` = ?,`createAt` = ?,`isRead` = ?,`episode` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`resourcePosition` = ?,`multiresolution` = ?,`videoWidth` = ?,`videoHeight` = ?,`downloadErrorCount` = ?,`subtitleStarted` = ?,`subjectId` = ?,`pageFrom` = ?,`lastPageFrom` = ?,`subjectName` = ?,`lastPlayTimeStamp` = ?,`fileType` = ?,`totalEpisode` = ?,`uploadBy` = ?,`sourceUrl` = ?,`urlCreateAt` = ?,`subtitleSelectId` = ?,`taskId` = ?,`sessionTime` = ?,`reportStatus` = ?,`downloadHeaderSize` = ?,`rootPath` = ?,`rootPathType` = ?,`thumbnail` = ?,`averageHueLight` = ?,`isTransferFailed` = ?,`isClosedTransferFailed` = ?,`subjectType` = ?,`genre` = ?,`subjectDurationSeconds` = ?,`currentDubLanName` = ?,`currentDubLanCode` = ?,`ops` = ?,`restrictLevel` = ?,`releaseDate` = ?,`countryName` = ?,`seNum` = ?,`subtitles` = ?,`imdbRate` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`subtitleIdType` = ?,`ugcVideoCollectionId` = ?,`ugcVideoId` = ?,`ugcVideoName` = ?,`ugcVideoCollectionName` = ?,`ugcVideoPosition` = ?,`ugcVideoType` = ?,`ugcCateLev1Id` = ?,`ugcCateLev2Id` = ?,`ugcCateLev3Id` = ?,`ugcCateLev4Id` = ?,`ugcVideoTrackId` = ?,`ugcVideoParentVideoId` = ?,`ugcVideoParentTrackId` = ?,`ugcVideoEpTitle` = ?,`ugcVideoIsVertical` = ?,`originData` = ?,`kidId` = ? WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            eVar.c(11, downloadBean.getProgress());
            eVar.c(12, downloadBean.getSupportRanges());
            eVar.c(13, downloadBean.getStatus());
            eVar.c(14, downloadBean.getType());
            eVar.c(15, downloadBean.getReadProgress());
            eVar.c(16, downloadBean.getCreateAt());
            eVar.c(17, downloadBean.getIsRead());
            eVar.c(18, downloadBean.getEpse());
            eVar.c(19, downloadBean.getEp());
            eVar.c(20, downloadBean.getSe());
            eVar.c(21, downloadBean.getResolution());
            eVar.c(22, downloadBean.getResourcePosition());
            eVar.c(23, downloadBean.getMultiresolution());
            eVar.c(24, downloadBean.getVideoWidth());
            eVar.c(25, downloadBean.getVideoHeight());
            eVar.c(26, downloadBean.getDownloadErrorCount());
            eVar.c(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.j(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                eVar.g(29);
            } else {
                eVar.j(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, downloadBean.getSubjectName());
            }
            eVar.c(32, downloadBean.getLastPlayTimeStamp());
            eVar.c(33, downloadBean.getFileType());
            eVar.c(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                eVar.g(35);
            } else {
                eVar.j(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                eVar.g(36);
            } else {
                eVar.j(36, downloadBean.getSourceUrl());
            }
            eVar.c(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                eVar.g(38);
            } else {
                eVar.j(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                eVar.g(39);
            } else {
                eVar.j(39, downloadBean.getTaskId());
            }
            eVar.c(40, downloadBean.getSessionTime());
            eVar.c(41, downloadBean.getReportStatus());
            eVar.c(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                eVar.g(43);
            } else {
                eVar.j(43, downloadBean.getRootPath());
            }
            eVar.c(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                eVar.g(45);
            } else {
                eVar.j(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                eVar.g(46);
            } else {
                eVar.j(46, downloadBean.getAverageHueLight());
            }
            eVar.c(47, downloadBean.getIsTransferFailed() ? 1L : 0L);
            eVar.c(48, downloadBean.getIsClosedTransferFailed() ? 1L : 0L);
            eVar.c(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                eVar.g(50);
            } else {
                eVar.j(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                eVar.g(51);
            } else {
                eVar.c(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                eVar.g(52);
            } else {
                eVar.j(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                eVar.g(53);
            } else {
                eVar.j(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                eVar.g(54);
            } else {
                eVar.j(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                eVar.g(55);
            } else {
                eVar.j(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                eVar.g(56);
            } else {
                eVar.j(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                eVar.g(57);
            } else {
                eVar.j(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                eVar.g(58);
            } else {
                eVar.c(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                eVar.g(59);
            } else {
                eVar.j(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                eVar.g(60);
            } else {
                eVar.j(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                eVar.g(61);
            } else {
                eVar.c(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                eVar.g(62);
            } else {
                eVar.c(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
            if (downloadBean.getSubtitleIdType() == null) {
                eVar.g(63);
            } else {
                eVar.j(63, downloadBean.getSubtitleIdType());
            }
            if (downloadBean.getUgcVideoCollectionId() == null) {
                eVar.g(64);
            } else {
                eVar.j(64, downloadBean.getUgcVideoCollectionId());
            }
            if (downloadBean.getUgcVideoId() == null) {
                eVar.g(65);
            } else {
                eVar.j(65, downloadBean.getUgcVideoId());
            }
            if (downloadBean.getUgcVideoName() == null) {
                eVar.g(66);
            } else {
                eVar.j(66, downloadBean.getUgcVideoName());
            }
            if (downloadBean.getUgcVideoCollectionName() == null) {
                eVar.g(67);
            } else {
                eVar.j(67, downloadBean.getUgcVideoCollectionName());
            }
            if (downloadBean.getUgcVideoPosition() == null) {
                eVar.g(68);
            } else {
                eVar.c(68, downloadBean.getUgcVideoPosition().intValue());
            }
            if (downloadBean.getUgcVideoType() == null) {
                eVar.g(69);
            } else {
                eVar.j(69, downloadBean.getUgcVideoType());
            }
            if (downloadBean.getUgcCateLev1Id() == null) {
                eVar.g(70);
            } else {
                eVar.c(70, downloadBean.getUgcCateLev1Id().intValue());
            }
            if (downloadBean.getUgcCateLev2Id() == null) {
                eVar.g(71);
            } else {
                eVar.c(71, downloadBean.getUgcCateLev2Id().intValue());
            }
            if (downloadBean.getUgcCateLev3Id() == null) {
                eVar.g(72);
            } else {
                eVar.c(72, downloadBean.getUgcCateLev3Id().intValue());
            }
            if (downloadBean.getUgcCateLev4Id() == null) {
                eVar.g(73);
            } else {
                eVar.c(73, downloadBean.getUgcCateLev4Id().intValue());
            }
            if (downloadBean.getUgcVideoTrackId() == null) {
                eVar.g(74);
            } else {
                eVar.j(74, downloadBean.getUgcVideoTrackId());
            }
            if (downloadBean.getUgcVideoParentVideoId() == null) {
                eVar.g(75);
            } else {
                eVar.j(75, downloadBean.getUgcVideoParentVideoId());
            }
            if (downloadBean.getUgcVideoParentTrackId() == null) {
                eVar.g(76);
            } else {
                eVar.j(76, downloadBean.getUgcVideoParentTrackId());
            }
            if (downloadBean.getUgcVideoEpTitle() == null) {
                eVar.g(77);
            } else {
                eVar.j(77, downloadBean.getUgcVideoEpTitle());
            }
            eVar.c(78, downloadBean.getUgcVideoIsVertical() ? 1L : 0L);
            if (downloadBean.getOriginData() == null) {
                eVar.g(79);
            } else {
                eVar.j(79, downloadBean.getOriginData());
            }
            if (downloadBean.getKidId() == null) {
                eVar.g(80);
            } else {
                eVar.j(80, downloadBean.getKidId());
            }
            if (downloadBean.getUrl() == null) {
                eVar.g(81);
            } else {
                eVar.j(81, downloadBean.getUrl());
            }
        }
    }

    public l0(RoomDatabase roomDatabase) {
        this.f69030a = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List A0(z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        Integer valueOf8;
        int i64;
        int i65;
        Integer valueOf9;
        int i66;
        String n028;
        int i67;
        String n029;
        int i68;
        int i69;
        String n030;
        int i70;
        String n031;
        int i71;
        int i72;
        int i73;
        boolean z12;
        String n032;
        int i74;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE status = 6 OR status = 3 AND fileType == 1 ORDER BY updateTimeStamp DESC ");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i75 = d12;
                int i76 = d13;
                int i77 = (int) D0.getLong(d22);
                int i78 = d14;
                int i79 = (int) D0.getLong(d23);
                int i80 = d15;
                int i81 = (int) D0.getLong(d24);
                int i82 = d25;
                long j12 = D0.getLong(i82);
                int i83 = d11;
                int i84 = d26;
                long j13 = D0.getLong(i84);
                d26 = i84;
                int i85 = d27;
                int i86 = d16;
                int i87 = (int) D0.getLong(i85);
                int i88 = d18;
                int i89 = d28;
                int i90 = d17;
                int i91 = (int) D0.getLong(i89);
                int i92 = d20;
                int i93 = d29;
                int i94 = d19;
                int i95 = (int) D0.getLong(i93);
                int i96 = d22;
                int i97 = d30;
                int i98 = d21;
                int i99 = (int) D0.getLong(i97);
                int i100 = d24;
                int i101 = d31;
                int i102 = d23;
                int i103 = (int) D0.getLong(i101);
                int i104 = d32;
                int i105 = (int) D0.getLong(i104);
                int i106 = d33;
                ArrayList arrayList2 = arrayList;
                int i107 = (int) D0.getLong(i106);
                int i108 = d34;
                int i109 = (int) D0.getLong(i108);
                int i110 = d35;
                int i111 = (int) D0.getLong(i110);
                int i112 = d36;
                int i113 = (int) D0.getLong(i112);
                int i114 = d37;
                int i115 = (int) D0.getLong(i114);
                int i116 = d38;
                if (D0.isNull(i116)) {
                    i11 = i85;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i116);
                    i11 = i85;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i117 = d43;
                int i118 = (int) D0.getLong(i117);
                int i119 = d44;
                int i120 = (int) D0.getLong(i119);
                int i121 = d45;
                if (D0.isNull(i121)) {
                    i16 = i117;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i121);
                    i16 = i117;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i122 = d48;
                if (D0.isNull(i122)) {
                    d48 = i122;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i122);
                    d48 = i122;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i123 = d51;
                int i124 = (int) D0.getLong(i123);
                int i125 = d52;
                long j17 = D0.getLong(i125);
                int i126 = d53;
                if (D0.isNull(i126)) {
                    d53 = i126;
                    i21 = i125;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i125;
                    n010 = D0.n0(i126);
                    d53 = i126;
                    i22 = d54;
                }
                int i127 = (int) D0.getLong(i22);
                int i128 = d55;
                if (D0.isNull(i128)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i128);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i128;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i128;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i129 = i27;
                int i130 = (int) D0.getLong(i28);
                int i131 = d60;
                if (D0.isNull(i131)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i131);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i28;
                    i31 = i130;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i28;
                    i31 = i130;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i32;
                    i41 = i33;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i32;
                    i41 = i33;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i131;
                    i58 = i29;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i131;
                    i58 = i29;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i64 = d83;
                }
                if (D0.isNull(i64)) {
                    i65 = i60;
                    i66 = d84;
                    valueOf9 = null;
                } else {
                    i65 = i60;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i64));
                    i66 = d84;
                }
                if (D0.isNull(i66)) {
                    i67 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i66);
                    i67 = d85;
                }
                if (D0.isNull(i67)) {
                    i68 = i52;
                    i69 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i67);
                    i68 = i52;
                    i69 = d86;
                }
                if (D0.isNull(i69)) {
                    d86 = i69;
                    i70 = d87;
                    n030 = null;
                } else {
                    d86 = i69;
                    n030 = D0.n0(i69);
                    i70 = d87;
                }
                if (D0.isNull(i70)) {
                    d87 = i70;
                    i72 = i62;
                    i71 = d88;
                    n031 = null;
                } else {
                    d87 = i70;
                    n031 = D0.n0(i70);
                    i71 = d88;
                    i72 = i62;
                }
                int i132 = i64;
                if (((int) D0.getLong(i71)) != 0) {
                    i73 = d89;
                    z12 = true;
                } else {
                    i73 = d89;
                    z12 = false;
                }
                if (D0.isNull(i73)) {
                    i74 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i73);
                    i74 = d90;
                }
                int i133 = i71;
                arrayList2.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i77, i79, i81, j12, j13, i87, i91, i95, i99, i103, i105, i107, i109, i111, i113, i115, n02, n03, n04, n05, j14, i118, i120, n06, n07, j15, n08, n09, j16, i124, j17, n010, i127, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i74) ? null : D0.n0(i74)));
                d11 = i83;
                d89 = i73;
                d90 = i74;
                d17 = i90;
                d19 = i94;
                d21 = i98;
                d23 = i102;
                d31 = i101;
                d33 = i106;
                d34 = i108;
                d36 = i112;
                d37 = i114;
                d43 = i16;
                d44 = i119;
                d51 = i123;
                d54 = i23;
                d58 = i129;
                d59 = i30;
                d57 = i34;
                d62 = i40;
                d63 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d61 = i58;
                d80 = i61;
                d81 = i63;
                d78 = i68;
                d82 = i72;
                d13 = i76;
                d14 = i78;
                d15 = i80;
                d25 = i82;
                d22 = i96;
                d32 = i104;
                d35 = i110;
                d45 = i121;
                d52 = i21;
                d55 = i25;
                d28 = i89;
                d29 = i93;
                d30 = i97;
                d84 = i66;
                d85 = i67;
                d16 = i86;
                d27 = i11;
                d18 = i88;
                d20 = i92;
                d24 = i100;
                d38 = i116;
                arrayList = arrayList2;
                d12 = i75;
                d88 = i133;
                d60 = i57;
                d79 = i65;
                d83 = i132;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean B0(z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        Integer valueOf;
        int i27;
        String n014;
        int i28;
        String n015;
        int i29;
        String n016;
        int i30;
        String n017;
        int i31;
        String n018;
        int i32;
        String n019;
        int i33;
        Integer valueOf2;
        int i34;
        String n020;
        int i35;
        String n021;
        int i36;
        Long valueOf3;
        int i37;
        Long valueOf4;
        int i38;
        String n022;
        int i39;
        String n023;
        int i40;
        String n024;
        int i41;
        String n025;
        int i42;
        String n026;
        int i43;
        Integer valueOf5;
        int i44;
        String n027;
        int i45;
        Integer valueOf6;
        int i46;
        Integer valueOf7;
        int i47;
        Integer valueOf8;
        int i48;
        Integer valueOf9;
        int i49;
        String n028;
        int i50;
        String n029;
        int i51;
        String n030;
        int i52;
        String n031;
        int i53;
        int i54;
        boolean z12;
        String n032;
        int i55;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE status ==5 AND fileType == 1 AND type != 1 ORDER BY updateTimeStamp DESC LIMIT 1");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    z10 = true;
                    i24 = d58;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    z11 = true;
                    i25 = d59;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = d62;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i27 = d62;
                }
                if (D0.isNull(i27)) {
                    i28 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i27);
                    i28 = d63;
                }
                if (D0.isNull(i28)) {
                    i29 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i28);
                    i29 = d64;
                }
                if (D0.isNull(i29)) {
                    i30 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i29);
                    i30 = d65;
                }
                if (D0.isNull(i30)) {
                    i31 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i30);
                    i31 = d66;
                }
                if (D0.isNull(i31)) {
                    i32 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i31);
                    i32 = d67;
                }
                if (D0.isNull(i32)) {
                    i33 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i32);
                    i33 = d68;
                }
                if (D0.isNull(i33)) {
                    i34 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i33));
                    i34 = d69;
                }
                if (D0.isNull(i34)) {
                    i35 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i34);
                    i35 = d70;
                }
                if (D0.isNull(i35)) {
                    i36 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i35);
                    i36 = d71;
                }
                if (D0.isNull(i36)) {
                    i37 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i36));
                    i37 = d72;
                }
                if (D0.isNull(i37)) {
                    i38 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i37));
                    i38 = d73;
                }
                if (D0.isNull(i38)) {
                    i39 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i38);
                    i39 = d74;
                }
                if (D0.isNull(i39)) {
                    i40 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i39);
                    i40 = d75;
                }
                if (D0.isNull(i40)) {
                    i41 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i40);
                    i41 = d76;
                }
                if (D0.isNull(i41)) {
                    i42 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i41);
                    i42 = d77;
                }
                if (D0.isNull(i42)) {
                    i43 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i42);
                    i43 = d78;
                }
                if (D0.isNull(i43)) {
                    i44 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i43));
                    i44 = d79;
                }
                if (D0.isNull(i44)) {
                    i45 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i44);
                    i45 = d80;
                }
                if (D0.isNull(i45)) {
                    i46 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i45));
                    i46 = d81;
                }
                if (D0.isNull(i46)) {
                    i47 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d82;
                }
                if (D0.isNull(i47)) {
                    i48 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d83;
                }
                if (D0.isNull(i48)) {
                    i49 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d84;
                }
                if (D0.isNull(i49)) {
                    i50 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i49);
                    i50 = d85;
                }
                if (D0.isNull(i50)) {
                    i51 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i50);
                    i51 = d86;
                }
                if (D0.isNull(i51)) {
                    i52 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i51);
                    i52 = d87;
                }
                if (D0.isNull(i52)) {
                    i53 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i52);
                    i53 = d88;
                }
                if (((int) D0.getLong(i53)) != 0) {
                    z12 = true;
                    i54 = d89;
                } else {
                    i54 = d89;
                    z12 = false;
                }
                if (D0.isNull(i54)) {
                    i55 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i54);
                    i55 = d90;
                }
                downloadBean = new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i74, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i55) ? null : D0.n0(i55));
            }
            return downloadBean;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List C0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE kidId = ? AND status = 5 AND fileType == 1 ORDER BY updateTimeStamp DESC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List D0(z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        Integer valueOf8;
        int i64;
        int i65;
        Integer valueOf9;
        int i66;
        String n028;
        int i67;
        String n029;
        int i68;
        int i69;
        String n030;
        int i70;
        String n031;
        int i71;
        int i72;
        int i73;
        boolean z12;
        String n032;
        int i74;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE (kidId IS NULL OR kidId = '') AND status = 5 AND fileType == 1 ORDER BY updateTimeStamp DESC");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i75 = d12;
                int i76 = d13;
                int i77 = (int) D0.getLong(d22);
                int i78 = d14;
                int i79 = (int) D0.getLong(d23);
                int i80 = d15;
                int i81 = (int) D0.getLong(d24);
                int i82 = d25;
                long j12 = D0.getLong(i82);
                int i83 = d11;
                int i84 = d26;
                long j13 = D0.getLong(i84);
                d26 = i84;
                int i85 = d27;
                int i86 = d16;
                int i87 = (int) D0.getLong(i85);
                int i88 = d18;
                int i89 = d28;
                int i90 = d17;
                int i91 = (int) D0.getLong(i89);
                int i92 = d20;
                int i93 = d29;
                int i94 = d19;
                int i95 = (int) D0.getLong(i93);
                int i96 = d22;
                int i97 = d30;
                int i98 = d21;
                int i99 = (int) D0.getLong(i97);
                int i100 = d24;
                int i101 = d31;
                int i102 = d23;
                int i103 = (int) D0.getLong(i101);
                int i104 = d32;
                int i105 = (int) D0.getLong(i104);
                int i106 = d33;
                ArrayList arrayList2 = arrayList;
                int i107 = (int) D0.getLong(i106);
                int i108 = d34;
                int i109 = (int) D0.getLong(i108);
                int i110 = d35;
                int i111 = (int) D0.getLong(i110);
                int i112 = d36;
                int i113 = (int) D0.getLong(i112);
                int i114 = d37;
                int i115 = (int) D0.getLong(i114);
                int i116 = d38;
                if (D0.isNull(i116)) {
                    i11 = i85;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i116);
                    i11 = i85;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i117 = d43;
                int i118 = (int) D0.getLong(i117);
                int i119 = d44;
                int i120 = (int) D0.getLong(i119);
                int i121 = d45;
                if (D0.isNull(i121)) {
                    i16 = i117;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i121);
                    i16 = i117;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i122 = d48;
                if (D0.isNull(i122)) {
                    d48 = i122;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i122);
                    d48 = i122;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i123 = d51;
                int i124 = (int) D0.getLong(i123);
                int i125 = d52;
                long j17 = D0.getLong(i125);
                int i126 = d53;
                if (D0.isNull(i126)) {
                    d53 = i126;
                    i21 = i125;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i125;
                    n010 = D0.n0(i126);
                    d53 = i126;
                    i22 = d54;
                }
                int i127 = (int) D0.getLong(i22);
                int i128 = d55;
                if (D0.isNull(i128)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i128);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i128;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i128;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i129 = i27;
                int i130 = (int) D0.getLong(i28);
                int i131 = d60;
                if (D0.isNull(i131)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i131);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i28;
                    i31 = i130;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i28;
                    i31 = i130;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i32;
                    i41 = i33;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i32;
                    i41 = i33;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i131;
                    i58 = i29;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i131;
                    i58 = i29;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i64 = d83;
                }
                if (D0.isNull(i64)) {
                    i65 = i60;
                    i66 = d84;
                    valueOf9 = null;
                } else {
                    i65 = i60;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i64));
                    i66 = d84;
                }
                if (D0.isNull(i66)) {
                    i67 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i66);
                    i67 = d85;
                }
                if (D0.isNull(i67)) {
                    i68 = i52;
                    i69 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i67);
                    i68 = i52;
                    i69 = d86;
                }
                if (D0.isNull(i69)) {
                    d86 = i69;
                    i70 = d87;
                    n030 = null;
                } else {
                    d86 = i69;
                    n030 = D0.n0(i69);
                    i70 = d87;
                }
                if (D0.isNull(i70)) {
                    d87 = i70;
                    i72 = i62;
                    i71 = d88;
                    n031 = null;
                } else {
                    d87 = i70;
                    n031 = D0.n0(i70);
                    i71 = d88;
                    i72 = i62;
                }
                int i132 = i64;
                if (((int) D0.getLong(i71)) != 0) {
                    i73 = d89;
                    z12 = true;
                } else {
                    i73 = d89;
                    z12 = false;
                }
                if (D0.isNull(i73)) {
                    i74 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i73);
                    i74 = d90;
                }
                int i133 = i71;
                arrayList2.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i77, i79, i81, j12, j13, i87, i91, i95, i99, i103, i105, i107, i109, i111, i113, i115, n02, n03, n04, n05, j14, i118, i120, n06, n07, j15, n08, n09, j16, i124, j17, n010, i127, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i74) ? null : D0.n0(i74)));
                d11 = i83;
                d89 = i73;
                d90 = i74;
                d17 = i90;
                d19 = i94;
                d21 = i98;
                d23 = i102;
                d31 = i101;
                d33 = i106;
                d34 = i108;
                d36 = i112;
                d37 = i114;
                d43 = i16;
                d44 = i119;
                d51 = i123;
                d54 = i23;
                d58 = i129;
                d59 = i30;
                d57 = i34;
                d62 = i40;
                d63 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d61 = i58;
                d80 = i61;
                d81 = i63;
                d78 = i68;
                d82 = i72;
                d13 = i76;
                d14 = i78;
                d15 = i80;
                d25 = i82;
                d22 = i96;
                d32 = i104;
                d35 = i110;
                d45 = i121;
                d52 = i21;
                d55 = i25;
                d28 = i89;
                d29 = i93;
                d30 = i97;
                d84 = i66;
                d85 = i67;
                d16 = i86;
                d27 = i11;
                d18 = i88;
                d20 = i92;
                d24 = i100;
                d38 = i116;
                arrayList = arrayList2;
                d12 = i75;
                d88 = i133;
                d60 = i57;
                d79 = i65;
                d83 = i132;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List E0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE kidId = ? AND status != 5 AND fileType == 1 ORDER BY createAt ASC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List F0(z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        Integer valueOf8;
        int i64;
        int i65;
        Integer valueOf9;
        int i66;
        String n028;
        int i67;
        String n029;
        int i68;
        int i69;
        String n030;
        int i70;
        String n031;
        int i71;
        int i72;
        int i73;
        boolean z12;
        String n032;
        int i74;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE (kidId IS NULL OR kidId = '') AND status != 5 AND fileType == 1 ORDER BY createAt ASC");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i75 = d12;
                int i76 = d13;
                int i77 = (int) D0.getLong(d22);
                int i78 = d14;
                int i79 = (int) D0.getLong(d23);
                int i80 = d15;
                int i81 = (int) D0.getLong(d24);
                int i82 = d25;
                long j12 = D0.getLong(i82);
                int i83 = d11;
                int i84 = d26;
                long j13 = D0.getLong(i84);
                d26 = i84;
                int i85 = d27;
                int i86 = d16;
                int i87 = (int) D0.getLong(i85);
                int i88 = d18;
                int i89 = d28;
                int i90 = d17;
                int i91 = (int) D0.getLong(i89);
                int i92 = d20;
                int i93 = d29;
                int i94 = d19;
                int i95 = (int) D0.getLong(i93);
                int i96 = d22;
                int i97 = d30;
                int i98 = d21;
                int i99 = (int) D0.getLong(i97);
                int i100 = d24;
                int i101 = d31;
                int i102 = d23;
                int i103 = (int) D0.getLong(i101);
                int i104 = d32;
                int i105 = (int) D0.getLong(i104);
                int i106 = d33;
                ArrayList arrayList2 = arrayList;
                int i107 = (int) D0.getLong(i106);
                int i108 = d34;
                int i109 = (int) D0.getLong(i108);
                int i110 = d35;
                int i111 = (int) D0.getLong(i110);
                int i112 = d36;
                int i113 = (int) D0.getLong(i112);
                int i114 = d37;
                int i115 = (int) D0.getLong(i114);
                int i116 = d38;
                if (D0.isNull(i116)) {
                    i11 = i85;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i116);
                    i11 = i85;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i117 = d43;
                int i118 = (int) D0.getLong(i117);
                int i119 = d44;
                int i120 = (int) D0.getLong(i119);
                int i121 = d45;
                if (D0.isNull(i121)) {
                    i16 = i117;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i121);
                    i16 = i117;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i122 = d48;
                if (D0.isNull(i122)) {
                    d48 = i122;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i122);
                    d48 = i122;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i123 = d51;
                int i124 = (int) D0.getLong(i123);
                int i125 = d52;
                long j17 = D0.getLong(i125);
                int i126 = d53;
                if (D0.isNull(i126)) {
                    d53 = i126;
                    i21 = i125;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i125;
                    n010 = D0.n0(i126);
                    d53 = i126;
                    i22 = d54;
                }
                int i127 = (int) D0.getLong(i22);
                int i128 = d55;
                if (D0.isNull(i128)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i128);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i128;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i128;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i129 = i27;
                int i130 = (int) D0.getLong(i28);
                int i131 = d60;
                if (D0.isNull(i131)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i131);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i28;
                    i31 = i130;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i28;
                    i31 = i130;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i32;
                    i41 = i33;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i32;
                    i41 = i33;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i131;
                    i58 = i29;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i131;
                    i58 = i29;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i64 = d83;
                }
                if (D0.isNull(i64)) {
                    i65 = i60;
                    i66 = d84;
                    valueOf9 = null;
                } else {
                    i65 = i60;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i64));
                    i66 = d84;
                }
                if (D0.isNull(i66)) {
                    i67 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i66);
                    i67 = d85;
                }
                if (D0.isNull(i67)) {
                    i68 = i52;
                    i69 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i67);
                    i68 = i52;
                    i69 = d86;
                }
                if (D0.isNull(i69)) {
                    d86 = i69;
                    i70 = d87;
                    n030 = null;
                } else {
                    d86 = i69;
                    n030 = D0.n0(i69);
                    i70 = d87;
                }
                if (D0.isNull(i70)) {
                    d87 = i70;
                    i72 = i62;
                    i71 = d88;
                    n031 = null;
                } else {
                    d87 = i70;
                    n031 = D0.n0(i70);
                    i71 = d88;
                    i72 = i62;
                }
                int i132 = i64;
                if (((int) D0.getLong(i71)) != 0) {
                    i73 = d89;
                    z12 = true;
                } else {
                    i73 = d89;
                    z12 = false;
                }
                if (D0.isNull(i73)) {
                    i74 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i73);
                    i74 = d90;
                }
                int i133 = i71;
                arrayList2.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i77, i79, i81, j12, j13, i87, i91, i95, i99, i103, i105, i107, i109, i111, i113, i115, n02, n03, n04, n05, j14, i118, i120, n06, n07, j15, n08, n09, j16, i124, j17, n010, i127, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i74) ? null : D0.n0(i74)));
                d11 = i83;
                d89 = i73;
                d90 = i74;
                d17 = i90;
                d19 = i94;
                d21 = i98;
                d23 = i102;
                d31 = i101;
                d33 = i106;
                d34 = i108;
                d36 = i112;
                d37 = i114;
                d43 = i16;
                d44 = i119;
                d51 = i123;
                d54 = i23;
                d58 = i129;
                d59 = i30;
                d57 = i34;
                d62 = i40;
                d63 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d61 = i58;
                d80 = i61;
                d81 = i63;
                d78 = i68;
                d82 = i72;
                d13 = i76;
                d14 = i78;
                d15 = i80;
                d25 = i82;
                d22 = i96;
                d32 = i104;
                d35 = i110;
                d45 = i121;
                d52 = i21;
                d55 = i25;
                d28 = i89;
                d29 = i93;
                d30 = i97;
                d84 = i66;
                d85 = i67;
                d16 = i86;
                d27 = i11;
                d18 = i88;
                d20 = i92;
                d24 = i100;
                d38 = i116;
                arrayList = arrayList2;
                d12 = i75;
                d88 = i133;
                d60 = i57;
                d79 = i65;
                d83 = i132;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean G0(z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        Integer valueOf;
        int i27;
        String n014;
        int i28;
        String n015;
        int i29;
        String n016;
        int i30;
        String n017;
        int i31;
        String n018;
        int i32;
        String n019;
        int i33;
        Integer valueOf2;
        int i34;
        String n020;
        int i35;
        String n021;
        int i36;
        Long valueOf3;
        int i37;
        Long valueOf4;
        int i38;
        String n022;
        int i39;
        String n023;
        int i40;
        String n024;
        int i41;
        String n025;
        int i42;
        String n026;
        int i43;
        Integer valueOf5;
        int i44;
        String n027;
        int i45;
        Integer valueOf6;
        int i46;
        Integer valueOf7;
        int i47;
        Integer valueOf8;
        int i48;
        Integer valueOf9;
        int i49;
        String n028;
        int i50;
        String n029;
        int i51;
        String n030;
        int i52;
        String n031;
        int i53;
        int i54;
        boolean z12;
        String n032;
        int i55;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE status = 5 AND fileType == 1 Limit 1 ");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    z10 = true;
                    i24 = d58;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    z11 = true;
                    i25 = d59;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = d62;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i27 = d62;
                }
                if (D0.isNull(i27)) {
                    i28 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i27);
                    i28 = d63;
                }
                if (D0.isNull(i28)) {
                    i29 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i28);
                    i29 = d64;
                }
                if (D0.isNull(i29)) {
                    i30 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i29);
                    i30 = d65;
                }
                if (D0.isNull(i30)) {
                    i31 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i30);
                    i31 = d66;
                }
                if (D0.isNull(i31)) {
                    i32 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i31);
                    i32 = d67;
                }
                if (D0.isNull(i32)) {
                    i33 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i32);
                    i33 = d68;
                }
                if (D0.isNull(i33)) {
                    i34 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i33));
                    i34 = d69;
                }
                if (D0.isNull(i34)) {
                    i35 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i34);
                    i35 = d70;
                }
                if (D0.isNull(i35)) {
                    i36 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i35);
                    i36 = d71;
                }
                if (D0.isNull(i36)) {
                    i37 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i36));
                    i37 = d72;
                }
                if (D0.isNull(i37)) {
                    i38 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i37));
                    i38 = d73;
                }
                if (D0.isNull(i38)) {
                    i39 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i38);
                    i39 = d74;
                }
                if (D0.isNull(i39)) {
                    i40 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i39);
                    i40 = d75;
                }
                if (D0.isNull(i40)) {
                    i41 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i40);
                    i41 = d76;
                }
                if (D0.isNull(i41)) {
                    i42 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i41);
                    i42 = d77;
                }
                if (D0.isNull(i42)) {
                    i43 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i42);
                    i43 = d78;
                }
                if (D0.isNull(i43)) {
                    i44 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i43));
                    i44 = d79;
                }
                if (D0.isNull(i44)) {
                    i45 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i44);
                    i45 = d80;
                }
                if (D0.isNull(i45)) {
                    i46 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i45));
                    i46 = d81;
                }
                if (D0.isNull(i46)) {
                    i47 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d82;
                }
                if (D0.isNull(i47)) {
                    i48 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d83;
                }
                if (D0.isNull(i48)) {
                    i49 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d84;
                }
                if (D0.isNull(i49)) {
                    i50 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i49);
                    i50 = d85;
                }
                if (D0.isNull(i50)) {
                    i51 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i50);
                    i51 = d86;
                }
                if (D0.isNull(i51)) {
                    i52 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i51);
                    i52 = d87;
                }
                if (D0.isNull(i52)) {
                    i53 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i52);
                    i53 = d88;
                }
                if (((int) D0.getLong(i53)) != 0) {
                    z12 = true;
                    i54 = d89;
                } else {
                    i54 = d89;
                    z12 = false;
                }
                if (D0.isNull(i54)) {
                    i55 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i54);
                    i55 = d90;
                }
                downloadBean = new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i74, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i55) ? null : D0.n0(i55));
            }
            return downloadBean;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean H0(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        int i27;
        Integer valueOf;
        int i28;
        String n014;
        int i29;
        String n015;
        int i30;
        String n016;
        int i31;
        String n017;
        int i32;
        String n018;
        int i33;
        String n019;
        int i34;
        Integer valueOf2;
        int i35;
        String n020;
        int i36;
        String n021;
        int i37;
        Long valueOf3;
        int i38;
        Long valueOf4;
        int i39;
        String n022;
        int i40;
        String n023;
        int i41;
        String n024;
        int i42;
        String n025;
        int i43;
        String n026;
        int i44;
        Integer valueOf5;
        int i45;
        String n027;
        int i46;
        Integer valueOf6;
        int i47;
        Integer valueOf7;
        int i48;
        Integer valueOf8;
        int i49;
        Integer valueOf9;
        int i50;
        String n028;
        int i51;
        String n029;
        int i52;
        String n030;
        int i53;
        String n031;
        int i54;
        int i55;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE type = 2 AND fileType = 2 AND path = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d58;
                    z10 = true;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d59;
                    z11 = true;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = i74;
                    i28 = d62;
                    valueOf = null;
                } else {
                    i27 = i74;
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i28 = d62;
                }
                if (D0.isNull(i28)) {
                    i29 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i28);
                    i29 = d63;
                }
                if (D0.isNull(i29)) {
                    i30 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i29);
                    i30 = d64;
                }
                if (D0.isNull(i30)) {
                    i31 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i30);
                    i31 = d65;
                }
                if (D0.isNull(i31)) {
                    i32 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i31);
                    i32 = d66;
                }
                if (D0.isNull(i32)) {
                    i33 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i32);
                    i33 = d67;
                }
                if (D0.isNull(i33)) {
                    i34 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i33);
                    i34 = d68;
                }
                if (D0.isNull(i34)) {
                    i35 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i34));
                    i35 = d69;
                }
                if (D0.isNull(i35)) {
                    i36 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i35);
                    i36 = d70;
                }
                if (D0.isNull(i36)) {
                    i37 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i36);
                    i37 = d71;
                }
                if (D0.isNull(i37)) {
                    i38 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i37));
                    i38 = d72;
                }
                if (D0.isNull(i38)) {
                    i39 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i38));
                    i39 = d73;
                }
                if (D0.isNull(i39)) {
                    i40 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i39);
                    i40 = d74;
                }
                if (D0.isNull(i40)) {
                    i41 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i40);
                    i41 = d75;
                }
                if (D0.isNull(i41)) {
                    i42 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i41);
                    i42 = d76;
                }
                if (D0.isNull(i42)) {
                    i43 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i42);
                    i43 = d77;
                }
                if (D0.isNull(i43)) {
                    i44 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i43);
                    i44 = d78;
                }
                if (D0.isNull(i44)) {
                    i45 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i44));
                    i45 = d79;
                }
                if (D0.isNull(i45)) {
                    i46 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i45);
                    i46 = d80;
                }
                if (D0.isNull(i46)) {
                    i47 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d81;
                }
                if (D0.isNull(i47)) {
                    i48 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d82;
                }
                if (D0.isNull(i48)) {
                    i49 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d83;
                }
                if (D0.isNull(i49)) {
                    i50 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d84;
                }
                if (D0.isNull(i50)) {
                    i51 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i50);
                    i51 = d85;
                }
                if (D0.isNull(i51)) {
                    i52 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i51);
                    i52 = d86;
                }
                if (D0.isNull(i52)) {
                    i53 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i52);
                    i53 = d87;
                }
                if (D0.isNull(i53)) {
                    i54 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i53);
                    i54 = d88;
                }
                if (((int) D0.getLong(i54)) != 0) {
                    i55 = d89;
                    z12 = true;
                } else {
                    i55 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i27, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i55) ? null : D0.n0(i55), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List I0(int i11, z3.b bVar) {
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
        int i18;
        String n07;
        int i19;
        String n08;
        int i20;
        String n09;
        int i21;
        int i22;
        String n010;
        int i23;
        String n011;
        int i24;
        int i25;
        int i26;
        String n012;
        int i27;
        int i28;
        boolean z10;
        int i29;
        boolean z11;
        String n013;
        int i30;
        int i31;
        int i32;
        Integer valueOf;
        int i33;
        String n014;
        int i34;
        String n015;
        int i35;
        int i36;
        String n016;
        int i37;
        String n017;
        int i38;
        String n018;
        int i39;
        String n019;
        int i40;
        int i41;
        int i42;
        Integer valueOf2;
        int i43;
        String n020;
        int i44;
        String n021;
        int i45;
        int i46;
        Long valueOf3;
        int i47;
        Long valueOf4;
        int i48;
        String n022;
        int i49;
        String n023;
        int i50;
        String n024;
        int i51;
        String n025;
        int i52;
        String n026;
        int i53;
        int i54;
        int i55;
        Integer valueOf5;
        int i56;
        String n027;
        int i57;
        int i58;
        int i59;
        Integer valueOf6;
        int i60;
        int i61;
        int i62;
        Integer valueOf7;
        int i63;
        int i64;
        int i65;
        Integer valueOf8;
        int i66;
        int i67;
        int i68;
        Integer valueOf9;
        int i69;
        String n028;
        int i70;
        String n029;
        int i71;
        int i72;
        String n030;
        int i73;
        String n031;
        int i74;
        int i75;
        int i76;
        boolean z12;
        String n032;
        int i77;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1 ORDER BY updateTimeStamp DESC Limit ?");
        try {
            D0.c(1, i11);
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i78 = d11;
                int i79 = d12;
                int i80 = (int) D0.getLong(d22);
                int i81 = d13;
                int i82 = (int) D0.getLong(d23);
                int i83 = d14;
                int i84 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                int i85 = d26;
                long j13 = D0.getLong(i85);
                d26 = i85;
                int i86 = d16;
                int i87 = d27;
                int i88 = d15;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i12 = i87;
                    i13 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i12 = i87;
                    i13 = d39;
                }
                if (D0.isNull(i13)) {
                    d39 = i13;
                    i14 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    d39 = i13;
                    i14 = d40;
                }
                if (D0.isNull(i14)) {
                    d40 = i14;
                    i15 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i14);
                    d40 = i14;
                    i15 = d41;
                }
                if (D0.isNull(i15)) {
                    d41 = i15;
                    i16 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i15);
                    d41 = i15;
                    i16 = d42;
                }
                long j14 = D0.getLong(i16);
                d42 = i16;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i17 = i119;
                    i18 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i17 = i119;
                    i18 = d46;
                }
                if (D0.isNull(i18)) {
                    d46 = i18;
                    i19 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i18);
                    d46 = i18;
                    i19 = d47;
                }
                long j15 = D0.getLong(i19);
                d47 = i19;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i20 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i20 = d49;
                }
                if (D0.isNull(i20)) {
                    d49 = i20;
                    i21 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i20);
                    d49 = i20;
                    i21 = d50;
                }
                long j16 = D0.getLong(i21);
                d50 = i21;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i22 = i127;
                    i23 = d54;
                    n010 = null;
                } else {
                    i22 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i23 = d54;
                }
                int i129 = (int) D0.getLong(i23);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i24 = i23;
                    i25 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i24 = i23;
                    i25 = d56;
                }
                if (D0.isNull(i25)) {
                    d56 = i25;
                    i26 = i130;
                    i27 = d57;
                    n012 = null;
                } else {
                    i26 = i130;
                    n012 = D0.n0(i25);
                    d56 = i25;
                    i27 = d57;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d58;
                    z10 = true;
                } else {
                    i28 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i28)) != 0) {
                    i29 = d59;
                    z11 = true;
                } else {
                    i29 = d59;
                    z11 = false;
                }
                int i131 = i28;
                int i132 = (int) D0.getLong(i29);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i30 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i30 = d61;
                }
                if (D0.isNull(i30)) {
                    i31 = i132;
                    i32 = i133;
                    i33 = d62;
                    valueOf = null;
                } else {
                    i31 = i132;
                    i32 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i30));
                    i33 = d62;
                }
                if (D0.isNull(i33)) {
                    i34 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i33);
                    i34 = d63;
                }
                if (D0.isNull(i34)) {
                    i35 = i27;
                    i36 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i34);
                    i35 = i27;
                    i36 = d64;
                }
                if (D0.isNull(i36)) {
                    d64 = i36;
                    i37 = d65;
                    n016 = null;
                } else {
                    d64 = i36;
                    n016 = D0.n0(i36);
                    i37 = d65;
                }
                if (D0.isNull(i37)) {
                    d65 = i37;
                    i38 = d66;
                    n017 = null;
                } else {
                    d65 = i37;
                    n017 = D0.n0(i37);
                    i38 = d66;
                }
                if (D0.isNull(i38)) {
                    d66 = i38;
                    i39 = d67;
                    n018 = null;
                } else {
                    d66 = i38;
                    n018 = D0.n0(i38);
                    i39 = d67;
                }
                if (D0.isNull(i39)) {
                    d67 = i39;
                    i40 = d68;
                    n019 = null;
                } else {
                    d67 = i39;
                    n019 = D0.n0(i39);
                    i40 = d68;
                }
                if (D0.isNull(i40)) {
                    i41 = i29;
                    i42 = i30;
                    i43 = d69;
                    valueOf2 = null;
                } else {
                    i41 = i29;
                    i42 = i30;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i40));
                    i43 = d69;
                }
                if (D0.isNull(i43)) {
                    i44 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i43);
                    i44 = d70;
                }
                if (D0.isNull(i44)) {
                    i45 = i40;
                    i46 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i44);
                    i45 = i40;
                    i46 = d71;
                }
                if (D0.isNull(i46)) {
                    d71 = i46;
                    i47 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i46;
                    valueOf3 = Long.valueOf(D0.getLong(i46));
                    i47 = d72;
                }
                if (D0.isNull(i47)) {
                    d72 = i47;
                    i48 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i47;
                    valueOf4 = Long.valueOf(D0.getLong(i47));
                    i48 = d73;
                }
                if (D0.isNull(i48)) {
                    d73 = i48;
                    i49 = d74;
                    n022 = null;
                } else {
                    d73 = i48;
                    n022 = D0.n0(i48);
                    i49 = d74;
                }
                if (D0.isNull(i49)) {
                    d74 = i49;
                    i50 = d75;
                    n023 = null;
                } else {
                    d74 = i49;
                    n023 = D0.n0(i49);
                    i50 = d75;
                }
                if (D0.isNull(i50)) {
                    d75 = i50;
                    i51 = d76;
                    n024 = null;
                } else {
                    d75 = i50;
                    n024 = D0.n0(i50);
                    i51 = d76;
                }
                if (D0.isNull(i51)) {
                    d76 = i51;
                    i52 = d77;
                    n025 = null;
                } else {
                    d76 = i51;
                    n025 = D0.n0(i51);
                    i52 = d77;
                }
                if (D0.isNull(i52)) {
                    d77 = i52;
                    i53 = d78;
                    n026 = null;
                } else {
                    d77 = i52;
                    n026 = D0.n0(i52);
                    i53 = d78;
                }
                if (D0.isNull(i53)) {
                    i54 = i43;
                    i55 = i44;
                    i56 = d79;
                    valueOf5 = null;
                } else {
                    i54 = i43;
                    i55 = i44;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i53));
                    i56 = d79;
                }
                if (D0.isNull(i56)) {
                    i57 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i56);
                    i57 = d80;
                }
                if (D0.isNull(i57)) {
                    i58 = i33;
                    i59 = i34;
                    i60 = d81;
                    valueOf6 = null;
                } else {
                    i58 = i33;
                    i59 = i34;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i57));
                    i60 = d81;
                }
                if (D0.isNull(i60)) {
                    i61 = i56;
                    i62 = i57;
                    i63 = d82;
                    valueOf7 = null;
                } else {
                    i61 = i56;
                    i62 = i57;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i60));
                    i63 = d82;
                }
                if (D0.isNull(i63)) {
                    i64 = i60;
                    i65 = i61;
                    i66 = d83;
                    valueOf8 = null;
                } else {
                    i64 = i60;
                    i65 = i61;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i63));
                    i66 = d83;
                }
                if (D0.isNull(i66)) {
                    i67 = i63;
                    i68 = i64;
                    i69 = d84;
                    valueOf9 = null;
                } else {
                    i67 = i63;
                    i68 = i64;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i66));
                    i69 = d84;
                }
                if (D0.isNull(i69)) {
                    i70 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i69);
                    i70 = d85;
                }
                if (D0.isNull(i70)) {
                    i71 = i53;
                    i72 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i70);
                    i71 = i53;
                    i72 = d86;
                }
                if (D0.isNull(i72)) {
                    d86 = i72;
                    i73 = d87;
                    n030 = null;
                } else {
                    d86 = i72;
                    n030 = D0.n0(i72);
                    i73 = d87;
                }
                if (D0.isNull(i73)) {
                    d87 = i73;
                    i75 = i69;
                    i74 = d88;
                    n031 = null;
                } else {
                    d87 = i73;
                    n031 = D0.n0(i73);
                    i74 = d88;
                    i75 = i69;
                }
                int i134 = i70;
                if (((int) D0.getLong(i74)) != 0) {
                    i76 = d89;
                    z12 = true;
                } else {
                    i76 = d89;
                    z12 = false;
                }
                if (D0.isNull(i76)) {
                    i77 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i76);
                    i77 = d90;
                }
                int i135 = i74;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i80, i82, i84, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i77) ? null : D0.n0(i77)));
                d89 = i76;
                d90 = i77;
                d15 = i88;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d27 = i12;
                d43 = i17;
                d51 = i125;
                d54 = i24;
                d58 = i131;
                d57 = i35;
                d59 = i41;
                d61 = i42;
                d68 = i45;
                d69 = i54;
                d70 = i55;
                d62 = i58;
                d63 = i59;
                d80 = i62;
                d79 = i65;
                d81 = i68;
                d78 = i71;
                d84 = i75;
                d85 = i134;
                d11 = i78;
                d12 = i79;
                d13 = i81;
                d14 = i83;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d38 = i118;
                d37 = i116;
                d45 = i123;
                d52 = i22;
                d55 = i26;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i66;
                d82 = i67;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d88 = i135;
                d16 = i86;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d60 = i32;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List J0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  ORDER BY episode ASC ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List K0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND status = 5  ORDER BY episode ASC ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean L0(String str, int i11, int i12, z3.b bVar) {
        String n02;
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
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        String n012;
        int i25;
        int i26;
        boolean z10;
        int i27;
        boolean z11;
        String n013;
        int i28;
        int i29;
        Integer valueOf;
        int i30;
        String n014;
        int i31;
        String n015;
        int i32;
        String n016;
        int i33;
        String n017;
        int i34;
        String n018;
        int i35;
        String n019;
        int i36;
        Integer valueOf2;
        int i37;
        String n020;
        int i38;
        String n021;
        int i39;
        Long valueOf3;
        int i40;
        Long valueOf4;
        int i41;
        String n022;
        int i42;
        String n023;
        int i43;
        String n024;
        int i44;
        String n025;
        int i45;
        String n026;
        int i46;
        Integer valueOf5;
        int i47;
        String n027;
        int i48;
        Integer valueOf6;
        int i49;
        Integer valueOf7;
        int i50;
        Integer valueOf8;
        int i51;
        Integer valueOf9;
        int i52;
        String n028;
        int i53;
        String n029;
        int i54;
        String n030;
        int i55;
        String n031;
        int i56;
        int i57;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  AND se =? AND ep =? ORDER BY resolution DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i58 = (int) D0.getLong(d22);
                int i59 = (int) D0.getLong(d23);
                int i60 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i61 = (int) D0.getLong(d27);
                int i62 = (int) D0.getLong(d28);
                int i63 = (int) D0.getLong(d29);
                int i64 = (int) D0.getLong(d30);
                int i65 = (int) D0.getLong(d31);
                int i66 = (int) D0.getLong(d32);
                int i67 = (int) D0.getLong(d33);
                int i68 = (int) D0.getLong(d34);
                int i69 = (int) D0.getLong(d35);
                int i70 = (int) D0.getLong(d36);
                int i71 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i13 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i13 = d39;
                }
                if (D0.isNull(i13)) {
                    i14 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d40;
                }
                if (D0.isNull(i14)) {
                    i15 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i14);
                    i15 = d41;
                }
                if (D0.isNull(i15)) {
                    i16 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i15);
                    i16 = d42;
                }
                long j14 = D0.getLong(i16);
                int i72 = (int) D0.getLong(d43);
                int i73 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                if (D0.isNull(d48)) {
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                int i74 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i21 = i74;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i74;
                    n010 = D0.n0(d53);
                    i22 = d54;
                }
                int i75 = (int) D0.getLong(i22);
                if (D0.isNull(d55)) {
                    i23 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i23 = d56;
                }
                if (D0.isNull(i23)) {
                    i24 = i75;
                    i25 = d57;
                    n012 = null;
                } else {
                    i24 = i75;
                    n012 = D0.n0(i23);
                    i25 = d57;
                }
                if (((int) D0.getLong(i25)) != 0) {
                    i26 = d58;
                    z10 = true;
                } else {
                    i26 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d59;
                    z11 = true;
                } else {
                    i27 = d59;
                    z11 = false;
                }
                int i76 = (int) D0.getLong(i27);
                if (D0.isNull(d60)) {
                    i28 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i28 = d61;
                }
                if (D0.isNull(i28)) {
                    i29 = i76;
                    i30 = d62;
                    valueOf = null;
                } else {
                    i29 = i76;
                    valueOf = Integer.valueOf((int) D0.getLong(i28));
                    i30 = d62;
                }
                if (D0.isNull(i30)) {
                    i31 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i30);
                    i31 = d63;
                }
                if (D0.isNull(i31)) {
                    i32 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i31);
                    i32 = d64;
                }
                if (D0.isNull(i32)) {
                    i33 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i32);
                    i33 = d65;
                }
                if (D0.isNull(i33)) {
                    i34 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i33);
                    i34 = d66;
                }
                if (D0.isNull(i34)) {
                    i35 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i34);
                    i35 = d67;
                }
                if (D0.isNull(i35)) {
                    i36 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i35);
                    i36 = d68;
                }
                if (D0.isNull(i36)) {
                    i37 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i36));
                    i37 = d69;
                }
                if (D0.isNull(i37)) {
                    i38 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i37);
                    i38 = d70;
                }
                if (D0.isNull(i38)) {
                    i39 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i38);
                    i39 = d71;
                }
                if (D0.isNull(i39)) {
                    i40 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i39));
                    i40 = d72;
                }
                if (D0.isNull(i40)) {
                    i41 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i40));
                    i41 = d73;
                }
                if (D0.isNull(i41)) {
                    i42 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i41);
                    i42 = d74;
                }
                if (D0.isNull(i42)) {
                    i43 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i42);
                    i43 = d75;
                }
                if (D0.isNull(i43)) {
                    i44 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i43);
                    i44 = d76;
                }
                if (D0.isNull(i44)) {
                    i45 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i44);
                    i45 = d77;
                }
                if (D0.isNull(i45)) {
                    i46 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i45);
                    i46 = d78;
                }
                if (D0.isNull(i46)) {
                    i47 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d79;
                }
                if (D0.isNull(i47)) {
                    i48 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i47);
                    i48 = d80;
                }
                if (D0.isNull(i48)) {
                    i49 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d81;
                }
                if (D0.isNull(i49)) {
                    i50 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d82;
                }
                if (D0.isNull(i50)) {
                    i51 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i50));
                    i51 = d83;
                }
                if (D0.isNull(i51)) {
                    i52 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i51));
                    i52 = d84;
                }
                if (D0.isNull(i52)) {
                    i53 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i52);
                    i53 = d85;
                }
                if (D0.isNull(i53)) {
                    i54 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i53);
                    i54 = d86;
                }
                if (D0.isNull(i54)) {
                    i55 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i54);
                    i55 = d87;
                }
                if (D0.isNull(i55)) {
                    i56 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i55);
                    i56 = d88;
                }
                if (((int) D0.getLong(i56)) != 0) {
                    i57 = d89;
                    z12 = true;
                } else {
                    i57 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i58, i59, i60, j12, j13, i61, i62, i63, i64, i65, i66, i67, i68, i69, i70, i71, n02, n03, n04, n05, j14, i72, i73, n06, n07, j15, n08, n09, j16, i21, j17, n010, i24, n011, n012, z10, z11, i29, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i57) ? null : D0.n0(i57), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List M0(z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        Integer valueOf8;
        int i64;
        int i65;
        Integer valueOf9;
        int i66;
        String n028;
        int i67;
        String n029;
        int i68;
        int i69;
        String n030;
        int i70;
        String n031;
        int i71;
        int i72;
        int i73;
        boolean z12;
        String n032;
        int i74;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i75 = d12;
                int i76 = d13;
                int i77 = (int) D0.getLong(d22);
                int i78 = d14;
                int i79 = (int) D0.getLong(d23);
                int i80 = d15;
                int i81 = (int) D0.getLong(d24);
                int i82 = d25;
                long j12 = D0.getLong(i82);
                int i83 = d11;
                int i84 = d26;
                long j13 = D0.getLong(i84);
                d26 = i84;
                int i85 = d27;
                int i86 = d16;
                int i87 = (int) D0.getLong(i85);
                int i88 = d18;
                int i89 = d28;
                int i90 = d17;
                int i91 = (int) D0.getLong(i89);
                int i92 = d20;
                int i93 = d29;
                int i94 = d19;
                int i95 = (int) D0.getLong(i93);
                int i96 = d22;
                int i97 = d30;
                int i98 = d21;
                int i99 = (int) D0.getLong(i97);
                int i100 = d24;
                int i101 = d31;
                int i102 = d23;
                int i103 = (int) D0.getLong(i101);
                int i104 = d32;
                int i105 = (int) D0.getLong(i104);
                int i106 = d33;
                ArrayList arrayList2 = arrayList;
                int i107 = (int) D0.getLong(i106);
                int i108 = d34;
                int i109 = (int) D0.getLong(i108);
                int i110 = d35;
                int i111 = (int) D0.getLong(i110);
                int i112 = d36;
                int i113 = (int) D0.getLong(i112);
                int i114 = d37;
                int i115 = (int) D0.getLong(i114);
                int i116 = d38;
                if (D0.isNull(i116)) {
                    i11 = i85;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i116);
                    i11 = i85;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i117 = d43;
                int i118 = (int) D0.getLong(i117);
                int i119 = d44;
                int i120 = (int) D0.getLong(i119);
                int i121 = d45;
                if (D0.isNull(i121)) {
                    i16 = i117;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i121);
                    i16 = i117;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i122 = d48;
                if (D0.isNull(i122)) {
                    d48 = i122;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i122);
                    d48 = i122;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i123 = d51;
                int i124 = (int) D0.getLong(i123);
                int i125 = d52;
                long j17 = D0.getLong(i125);
                int i126 = d53;
                if (D0.isNull(i126)) {
                    d53 = i126;
                    i21 = i125;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i125;
                    n010 = D0.n0(i126);
                    d53 = i126;
                    i22 = d54;
                }
                int i127 = (int) D0.getLong(i22);
                int i128 = d55;
                if (D0.isNull(i128)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i128);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i128;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i128;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i129 = i27;
                int i130 = (int) D0.getLong(i28);
                int i131 = d60;
                if (D0.isNull(i131)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i131);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i28;
                    i31 = i130;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i28;
                    i31 = i130;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i32;
                    i41 = i33;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i32;
                    i41 = i33;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i131;
                    i58 = i29;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i131;
                    i58 = i29;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i64 = d83;
                }
                if (D0.isNull(i64)) {
                    i65 = i60;
                    i66 = d84;
                    valueOf9 = null;
                } else {
                    i65 = i60;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i64));
                    i66 = d84;
                }
                if (D0.isNull(i66)) {
                    i67 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i66);
                    i67 = d85;
                }
                if (D0.isNull(i67)) {
                    i68 = i52;
                    i69 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i67);
                    i68 = i52;
                    i69 = d86;
                }
                if (D0.isNull(i69)) {
                    d86 = i69;
                    i70 = d87;
                    n030 = null;
                } else {
                    d86 = i69;
                    n030 = D0.n0(i69);
                    i70 = d87;
                }
                if (D0.isNull(i70)) {
                    d87 = i70;
                    i72 = i62;
                    i71 = d88;
                    n031 = null;
                } else {
                    d87 = i70;
                    n031 = D0.n0(i70);
                    i71 = d88;
                    i72 = i62;
                }
                int i132 = i64;
                if (((int) D0.getLong(i71)) != 0) {
                    i73 = d89;
                    z12 = true;
                } else {
                    i73 = d89;
                    z12 = false;
                }
                if (D0.isNull(i73)) {
                    i74 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i73);
                    i74 = d90;
                }
                int i133 = i71;
                arrayList2.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i77, i79, i81, j12, j13, i87, i91, i95, i99, i103, i105, i107, i109, i111, i113, i115, n02, n03, n04, n05, j14, i118, i120, n06, n07, j15, n08, n09, j16, i124, j17, n010, i127, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i74) ? null : D0.n0(i74)));
                d11 = i83;
                d89 = i73;
                d90 = i74;
                d17 = i90;
                d19 = i94;
                d21 = i98;
                d23 = i102;
                d31 = i101;
                d33 = i106;
                d34 = i108;
                d36 = i112;
                d37 = i114;
                d43 = i16;
                d44 = i119;
                d51 = i123;
                d54 = i23;
                d58 = i129;
                d59 = i30;
                d57 = i34;
                d62 = i40;
                d63 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d61 = i58;
                d80 = i61;
                d81 = i63;
                d78 = i68;
                d82 = i72;
                d13 = i76;
                d14 = i78;
                d15 = i80;
                d25 = i82;
                d22 = i96;
                d32 = i104;
                d35 = i110;
                d45 = i121;
                d52 = i21;
                d55 = i25;
                d28 = i89;
                d29 = i93;
                d30 = i97;
                d84 = i66;
                d85 = i67;
                d16 = i86;
                d27 = i11;
                d18 = i88;
                d20 = i92;
                d24 = i100;
                d38 = i116;
                arrayList = arrayList2;
                d12 = i75;
                d88 = i133;
                d60 = i57;
                d79 = i65;
                d83 = i132;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N0(z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        Integer valueOf8;
        int i64;
        int i65;
        Integer valueOf9;
        int i66;
        String n028;
        int i67;
        String n029;
        int i68;
        int i69;
        String n030;
        int i70;
        String n031;
        int i71;
        int i72;
        int i73;
        boolean z12;
        String n032;
        int i74;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType = 3 ORDER BY updateTimeStamp DESC ");
        try {
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i75 = d12;
                int i76 = d13;
                int i77 = (int) D0.getLong(d22);
                int i78 = d14;
                int i79 = (int) D0.getLong(d23);
                int i80 = d15;
                int i81 = (int) D0.getLong(d24);
                int i82 = d25;
                long j12 = D0.getLong(i82);
                int i83 = d11;
                int i84 = d26;
                long j13 = D0.getLong(i84);
                d26 = i84;
                int i85 = d27;
                int i86 = d16;
                int i87 = (int) D0.getLong(i85);
                int i88 = d18;
                int i89 = d28;
                int i90 = d17;
                int i91 = (int) D0.getLong(i89);
                int i92 = d20;
                int i93 = d29;
                int i94 = d19;
                int i95 = (int) D0.getLong(i93);
                int i96 = d22;
                int i97 = d30;
                int i98 = d21;
                int i99 = (int) D0.getLong(i97);
                int i100 = d24;
                int i101 = d31;
                int i102 = d23;
                int i103 = (int) D0.getLong(i101);
                int i104 = d32;
                int i105 = (int) D0.getLong(i104);
                int i106 = d33;
                ArrayList arrayList2 = arrayList;
                int i107 = (int) D0.getLong(i106);
                int i108 = d34;
                int i109 = (int) D0.getLong(i108);
                int i110 = d35;
                int i111 = (int) D0.getLong(i110);
                int i112 = d36;
                int i113 = (int) D0.getLong(i112);
                int i114 = d37;
                int i115 = (int) D0.getLong(i114);
                int i116 = d38;
                if (D0.isNull(i116)) {
                    i11 = i85;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i116);
                    i11 = i85;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i117 = d43;
                int i118 = (int) D0.getLong(i117);
                int i119 = d44;
                int i120 = (int) D0.getLong(i119);
                int i121 = d45;
                if (D0.isNull(i121)) {
                    i16 = i117;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i121);
                    i16 = i117;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i122 = d48;
                if (D0.isNull(i122)) {
                    d48 = i122;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i122);
                    d48 = i122;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i123 = d51;
                int i124 = (int) D0.getLong(i123);
                int i125 = d52;
                long j17 = D0.getLong(i125);
                int i126 = d53;
                if (D0.isNull(i126)) {
                    d53 = i126;
                    i21 = i125;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i125;
                    n010 = D0.n0(i126);
                    d53 = i126;
                    i22 = d54;
                }
                int i127 = (int) D0.getLong(i22);
                int i128 = d55;
                if (D0.isNull(i128)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i128);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i128;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i128;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i129 = i27;
                int i130 = (int) D0.getLong(i28);
                int i131 = d60;
                if (D0.isNull(i131)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i131);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i28;
                    i31 = i130;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i28;
                    i31 = i130;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i32;
                    i41 = i33;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i32;
                    i41 = i33;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i131;
                    i58 = i29;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i131;
                    i58 = i29;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i64 = d83;
                }
                if (D0.isNull(i64)) {
                    i65 = i60;
                    i66 = d84;
                    valueOf9 = null;
                } else {
                    i65 = i60;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i64));
                    i66 = d84;
                }
                if (D0.isNull(i66)) {
                    i67 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i66);
                    i67 = d85;
                }
                if (D0.isNull(i67)) {
                    i68 = i52;
                    i69 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i67);
                    i68 = i52;
                    i69 = d86;
                }
                if (D0.isNull(i69)) {
                    d86 = i69;
                    i70 = d87;
                    n030 = null;
                } else {
                    d86 = i69;
                    n030 = D0.n0(i69);
                    i70 = d87;
                }
                if (D0.isNull(i70)) {
                    d87 = i70;
                    i72 = i62;
                    i71 = d88;
                    n031 = null;
                } else {
                    d87 = i70;
                    n031 = D0.n0(i70);
                    i71 = d88;
                    i72 = i62;
                }
                int i132 = i64;
                if (((int) D0.getLong(i71)) != 0) {
                    i73 = d89;
                    z12 = true;
                } else {
                    i73 = d89;
                    z12 = false;
                }
                if (D0.isNull(i73)) {
                    i74 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i73);
                    i74 = d90;
                }
                int i133 = i71;
                arrayList2.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i77, i79, i81, j12, j13, i87, i91, i95, i99, i103, i105, i107, i109, i111, i113, i115, n02, n03, n04, n05, j14, i118, i120, n06, n07, j15, n08, n09, j16, i124, j17, n010, i127, n011, n012, z10, z11, i31, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i74) ? null : D0.n0(i74)));
                d11 = i83;
                d89 = i73;
                d90 = i74;
                d17 = i90;
                d19 = i94;
                d21 = i98;
                d23 = i102;
                d31 = i101;
                d33 = i106;
                d34 = i108;
                d36 = i112;
                d37 = i114;
                d43 = i16;
                d44 = i119;
                d51 = i123;
                d54 = i23;
                d58 = i129;
                d59 = i30;
                d57 = i34;
                d62 = i40;
                d63 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d61 = i58;
                d80 = i61;
                d81 = i63;
                d78 = i68;
                d82 = i72;
                d13 = i76;
                d14 = i78;
                d15 = i80;
                d25 = i82;
                d22 = i96;
                d32 = i104;
                d35 = i110;
                d45 = i121;
                d52 = i21;
                d55 = i25;
                d28 = i89;
                d29 = i93;
                d30 = i97;
                d84 = i66;
                d85 = i67;
                d16 = i86;
                d27 = i11;
                d18 = i88;
                d20 = i92;
                d24 = i100;
                d38 = i116;
                arrayList = arrayList2;
                d12 = i75;
                d88 = i133;
                d60 = i57;
                d79 = i65;
                d83 = i132;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE ugcVideoCollectionId = ? ORDER BY ugcVideoPosition ASC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean P0(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        int i27;
        Integer valueOf;
        int i28;
        String n014;
        int i29;
        String n015;
        int i30;
        String n016;
        int i31;
        String n017;
        int i32;
        String n018;
        int i33;
        String n019;
        int i34;
        Integer valueOf2;
        int i35;
        String n020;
        int i36;
        String n021;
        int i37;
        Long valueOf3;
        int i38;
        Long valueOf4;
        int i39;
        String n022;
        int i40;
        String n023;
        int i41;
        String n024;
        int i42;
        String n025;
        int i43;
        String n026;
        int i44;
        Integer valueOf5;
        int i45;
        String n027;
        int i46;
        Integer valueOf6;
        int i47;
        Integer valueOf7;
        int i48;
        Integer valueOf8;
        int i49;
        Integer valueOf9;
        int i50;
        String n028;
        int i51;
        String n029;
        int i52;
        String n030;
        int i53;
        String n031;
        int i54;
        int i55;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE ugcVideoId = ?  ORDER BY resolution DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d58;
                    z10 = true;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d59;
                    z11 = true;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = i74;
                    i28 = d62;
                    valueOf = null;
                } else {
                    i27 = i74;
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i28 = d62;
                }
                if (D0.isNull(i28)) {
                    i29 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i28);
                    i29 = d63;
                }
                if (D0.isNull(i29)) {
                    i30 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i29);
                    i30 = d64;
                }
                if (D0.isNull(i30)) {
                    i31 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i30);
                    i31 = d65;
                }
                if (D0.isNull(i31)) {
                    i32 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i31);
                    i32 = d66;
                }
                if (D0.isNull(i32)) {
                    i33 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i32);
                    i33 = d67;
                }
                if (D0.isNull(i33)) {
                    i34 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i33);
                    i34 = d68;
                }
                if (D0.isNull(i34)) {
                    i35 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i34));
                    i35 = d69;
                }
                if (D0.isNull(i35)) {
                    i36 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i35);
                    i36 = d70;
                }
                if (D0.isNull(i36)) {
                    i37 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i36);
                    i37 = d71;
                }
                if (D0.isNull(i37)) {
                    i38 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i37));
                    i38 = d72;
                }
                if (D0.isNull(i38)) {
                    i39 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i38));
                    i39 = d73;
                }
                if (D0.isNull(i39)) {
                    i40 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i39);
                    i40 = d74;
                }
                if (D0.isNull(i40)) {
                    i41 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i40);
                    i41 = d75;
                }
                if (D0.isNull(i41)) {
                    i42 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i41);
                    i42 = d76;
                }
                if (D0.isNull(i42)) {
                    i43 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i42);
                    i43 = d77;
                }
                if (D0.isNull(i43)) {
                    i44 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i43);
                    i44 = d78;
                }
                if (D0.isNull(i44)) {
                    i45 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i44));
                    i45 = d79;
                }
                if (D0.isNull(i45)) {
                    i46 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i45);
                    i46 = d80;
                }
                if (D0.isNull(i46)) {
                    i47 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d81;
                }
                if (D0.isNull(i47)) {
                    i48 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d82;
                }
                if (D0.isNull(i48)) {
                    i49 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d83;
                }
                if (D0.isNull(i49)) {
                    i50 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d84;
                }
                if (D0.isNull(i50)) {
                    i51 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i50);
                    i51 = d85;
                }
                if (D0.isNull(i51)) {
                    i52 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i51);
                    i52 = d86;
                }
                if (D0.isNull(i52)) {
                    i53 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i52);
                    i53 = d87;
                }
                if (D0.isNull(i53)) {
                    i54 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i53);
                    i54 = d88;
                }
                if (((int) D0.getLong(i54)) != 0) {
                    i55 = d89;
                    z12 = true;
                } else {
                    i55 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i27, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i55) ? null : D0.n0(i55), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Q0(DownloadBean downloadBean, z3.b bVar) {
        this.f69031b.d(bVar, downloadBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit R0(DownloadBean downloadBean, z3.b bVar) {
        this.f69033d.c(bVar, downloadBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit S0(long j11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET duration = ? WHERE resourceId = ? ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
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
    public static /* synthetic */ Unit T0(long j11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET lastPlayTimeStamp = ? WHERE resourceId = ? ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
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
    public static /* synthetic */ Unit U0(long j11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET readProgress = ? WHERE resourceId = ? ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
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
    public static /* synthetic */ Unit V0(int i11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET status = ? WHERE resourceId = ? ");
        try {
            D0.c(1, i11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
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
    public static /* synthetic */ Unit W0(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET restrictLevel = ?, releaseDate = ?, countryName = ?, subtitles = ?, seNum = ?, genre = ?, imdbRate = ? WHERE resourceId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            if (str3 == null) {
                D0.g(3);
            } else {
                D0.j(3, str3);
            }
            if (str4 == null) {
                D0.g(4);
            } else {
                D0.j(4, str4);
            }
            if (num == null) {
                D0.g(5);
            } else {
                D0.c(5, num.intValue());
            }
            if (str5 == null) {
                D0.g(6);
            } else {
                D0.j(6, str5);
            }
            if (str6 == null) {
                D0.g(7);
            } else {
                D0.j(7, str6);
            }
            if (str7 == null) {
                D0.g(8);
            } else {
                D0.j(8, str7);
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
    public static /* synthetic */ Unit X0(String str, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET subtitleSelectId = ? WHERE resourceId = ? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
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
    public static /* synthetic */ Unit Y0(int i11, int i12, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE DOWNLOAD_TABLE SET videoWidth = ?, videoHeight = ? WHERE resourceId = ? ");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            if (str == null) {
                D0.g(3);
            } else {
                D0.j(3, str);
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

    public static List q0() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r0(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM DOWNLOAD_TABLE WHERE url=?");
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
    public static /* synthetic */ Unit s0(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM DOWNLOAD_TABLE WHERE resourceId=?");
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
    public static /* synthetic */ Unit t0(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM DOWNLOAD_TABLE WHERE resourceId=? AND fileType =  3 ");
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
    public static /* synthetic */ List u0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY createAt DESC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean v0(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        int i27;
        Integer valueOf;
        int i28;
        String n014;
        int i29;
        String n015;
        int i30;
        String n016;
        int i31;
        String n017;
        int i32;
        String n018;
        int i33;
        String n019;
        int i34;
        Integer valueOf2;
        int i35;
        String n020;
        int i36;
        String n021;
        int i37;
        Long valueOf3;
        int i38;
        Long valueOf4;
        int i39;
        String n022;
        int i40;
        String n023;
        int i41;
        String n024;
        int i42;
        String n025;
        int i43;
        String n026;
        int i44;
        Integer valueOf5;
        int i45;
        String n027;
        int i46;
        Integer valueOf6;
        int i47;
        Integer valueOf7;
        int i48;
        Integer valueOf8;
        int i49;
        Integer valueOf9;
        int i50;
        String n028;
        int i51;
        String n029;
        int i52;
        String n030;
        int i53;
        String n031;
        int i54;
        int i55;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE resourceId = ? ORDER BY createAt DESC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d58;
                    z10 = true;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d59;
                    z11 = true;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = i74;
                    i28 = d62;
                    valueOf = null;
                } else {
                    i27 = i74;
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i28 = d62;
                }
                if (D0.isNull(i28)) {
                    i29 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i28);
                    i29 = d63;
                }
                if (D0.isNull(i29)) {
                    i30 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i29);
                    i30 = d64;
                }
                if (D0.isNull(i30)) {
                    i31 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i30);
                    i31 = d65;
                }
                if (D0.isNull(i31)) {
                    i32 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i31);
                    i32 = d66;
                }
                if (D0.isNull(i32)) {
                    i33 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i32);
                    i33 = d67;
                }
                if (D0.isNull(i33)) {
                    i34 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i33);
                    i34 = d68;
                }
                if (D0.isNull(i34)) {
                    i35 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i34));
                    i35 = d69;
                }
                if (D0.isNull(i35)) {
                    i36 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i35);
                    i36 = d70;
                }
                if (D0.isNull(i36)) {
                    i37 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i36);
                    i37 = d71;
                }
                if (D0.isNull(i37)) {
                    i38 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i37));
                    i38 = d72;
                }
                if (D0.isNull(i38)) {
                    i39 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i38));
                    i39 = d73;
                }
                if (D0.isNull(i39)) {
                    i40 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i39);
                    i40 = d74;
                }
                if (D0.isNull(i40)) {
                    i41 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i40);
                    i41 = d75;
                }
                if (D0.isNull(i41)) {
                    i42 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i41);
                    i42 = d76;
                }
                if (D0.isNull(i42)) {
                    i43 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i42);
                    i43 = d77;
                }
                if (D0.isNull(i43)) {
                    i44 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i43);
                    i44 = d78;
                }
                if (D0.isNull(i44)) {
                    i45 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i44));
                    i45 = d79;
                }
                if (D0.isNull(i45)) {
                    i46 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i45);
                    i46 = d80;
                }
                if (D0.isNull(i46)) {
                    i47 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d81;
                }
                if (D0.isNull(i47)) {
                    i48 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d82;
                }
                if (D0.isNull(i48)) {
                    i49 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d83;
                }
                if (D0.isNull(i49)) {
                    i50 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d84;
                }
                if (D0.isNull(i50)) {
                    i51 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i50);
                    i51 = d85;
                }
                if (D0.isNull(i51)) {
                    i52 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i51);
                    i52 = d86;
                }
                if (D0.isNull(i52)) {
                    i53 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i52);
                    i53 = d87;
                }
                if (D0.isNull(i53)) {
                    i54 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i53);
                    i54 = d88;
                }
                if (((int) D0.getLong(i54)) != 0) {
                    i55 = d89;
                    z12 = true;
                } else {
                    i55 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i27, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i55) ? null : D0.n0(i55), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean w0(String str, int i11, z3.b bVar) {
        String n02;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        String n07;
        int i17;
        String n08;
        int i18;
        String n09;
        int i19;
        int i20;
        String n010;
        int i21;
        String n011;
        int i22;
        int i23;
        String n012;
        int i24;
        int i25;
        boolean z10;
        int i26;
        boolean z11;
        String n013;
        int i27;
        int i28;
        Integer valueOf;
        int i29;
        String n014;
        int i30;
        String n015;
        int i31;
        String n016;
        int i32;
        String n017;
        int i33;
        String n018;
        int i34;
        String n019;
        int i35;
        Integer valueOf2;
        int i36;
        String n020;
        int i37;
        String n021;
        int i38;
        Long valueOf3;
        int i39;
        Long valueOf4;
        int i40;
        String n022;
        int i41;
        String n023;
        int i42;
        String n024;
        int i43;
        String n025;
        int i44;
        String n026;
        int i45;
        Integer valueOf5;
        int i46;
        String n027;
        int i47;
        Integer valueOf6;
        int i48;
        Integer valueOf7;
        int i49;
        Integer valueOf8;
        int i50;
        Integer valueOf9;
        int i51;
        String n028;
        int i52;
        String n029;
        int i53;
        String n030;
        int i54;
        String n031;
        int i55;
        int i56;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i57 = (int) D0.getLong(d22);
                int i58 = (int) D0.getLong(d23);
                int i59 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i60 = (int) D0.getLong(d27);
                int i61 = (int) D0.getLong(d28);
                int i62 = (int) D0.getLong(d29);
                int i63 = (int) D0.getLong(d30);
                int i64 = (int) D0.getLong(d31);
                int i65 = (int) D0.getLong(d32);
                int i66 = (int) D0.getLong(d33);
                int i67 = (int) D0.getLong(d34);
                int i68 = (int) D0.getLong(d35);
                int i69 = (int) D0.getLong(d36);
                int i70 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                int i71 = (int) D0.getLong(d43);
                int i72 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i16 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i16 = d46;
                }
                if (D0.isNull(i16)) {
                    i17 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i16);
                    i17 = d47;
                }
                long j15 = D0.getLong(i17);
                if (D0.isNull(d48)) {
                    i18 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i18 = d49;
                }
                if (D0.isNull(i18)) {
                    i19 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i18);
                    i19 = d50;
                }
                long j16 = D0.getLong(i19);
                int i73 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i20 = i73;
                    i21 = d54;
                    n010 = null;
                } else {
                    i20 = i73;
                    n010 = D0.n0(d53);
                    i21 = d54;
                }
                int i74 = (int) D0.getLong(i21);
                if (D0.isNull(d55)) {
                    i22 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i22 = d56;
                }
                if (D0.isNull(i22)) {
                    i23 = i74;
                    i24 = d57;
                    n012 = null;
                } else {
                    i23 = i74;
                    n012 = D0.n0(i22);
                    i24 = d57;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d58;
                    z10 = true;
                } else {
                    i25 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i25)) != 0) {
                    i26 = d59;
                    z11 = true;
                } else {
                    i26 = d59;
                    z11 = false;
                }
                int i75 = (int) D0.getLong(i26);
                if (D0.isNull(d60)) {
                    i27 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i27 = d61;
                }
                if (D0.isNull(i27)) {
                    i28 = i75;
                    i29 = d62;
                    valueOf = null;
                } else {
                    i28 = i75;
                    valueOf = Integer.valueOf((int) D0.getLong(i27));
                    i29 = d62;
                }
                if (D0.isNull(i29)) {
                    i30 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i29);
                    i30 = d63;
                }
                if (D0.isNull(i30)) {
                    i31 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i30);
                    i31 = d64;
                }
                if (D0.isNull(i31)) {
                    i32 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i31);
                    i32 = d65;
                }
                if (D0.isNull(i32)) {
                    i33 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i32);
                    i33 = d66;
                }
                if (D0.isNull(i33)) {
                    i34 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i33);
                    i34 = d67;
                }
                if (D0.isNull(i34)) {
                    i35 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i34);
                    i35 = d68;
                }
                if (D0.isNull(i35)) {
                    i36 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i35));
                    i36 = d69;
                }
                if (D0.isNull(i36)) {
                    i37 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i36);
                    i37 = d70;
                }
                if (D0.isNull(i37)) {
                    i38 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i37);
                    i38 = d71;
                }
                if (D0.isNull(i38)) {
                    i39 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i38));
                    i39 = d72;
                }
                if (D0.isNull(i39)) {
                    i40 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i39));
                    i40 = d73;
                }
                if (D0.isNull(i40)) {
                    i41 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i40);
                    i41 = d74;
                }
                if (D0.isNull(i41)) {
                    i42 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i41);
                    i42 = d75;
                }
                if (D0.isNull(i42)) {
                    i43 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i42);
                    i43 = d76;
                }
                if (D0.isNull(i43)) {
                    i44 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i43);
                    i44 = d77;
                }
                if (D0.isNull(i44)) {
                    i45 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i44);
                    i45 = d78;
                }
                if (D0.isNull(i45)) {
                    i46 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i45));
                    i46 = d79;
                }
                if (D0.isNull(i46)) {
                    i47 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i46);
                    i47 = d80;
                }
                if (D0.isNull(i47)) {
                    i48 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d81;
                }
                if (D0.isNull(i48)) {
                    i49 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d82;
                }
                if (D0.isNull(i49)) {
                    i50 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d83;
                }
                if (D0.isNull(i50)) {
                    i51 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i50));
                    i51 = d84;
                }
                if (D0.isNull(i51)) {
                    i52 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i51);
                    i52 = d85;
                }
                if (D0.isNull(i52)) {
                    i53 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i52);
                    i53 = d86;
                }
                if (D0.isNull(i53)) {
                    i54 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i53);
                    i54 = d87;
                }
                if (D0.isNull(i54)) {
                    i55 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i54);
                    i55 = d88;
                }
                if (((int) D0.getLong(i55)) != 0) {
                    i56 = d89;
                    z12 = true;
                } else {
                    i56 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i57, i58, i59, j12, j13, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, i70, n02, n03, n04, n05, j14, i71, i72, n06, n07, j15, n08, n09, j16, i20, j17, n010, i23, n011, n012, z10, z11, i28, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i56) ? null : D0.n0(i56), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean x0(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        String n06;
        int i15;
        String n07;
        int i16;
        String n08;
        int i17;
        String n09;
        int i18;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        int i22;
        String n012;
        int i23;
        int i24;
        boolean z10;
        int i25;
        boolean z11;
        String n013;
        int i26;
        int i27;
        Integer valueOf;
        int i28;
        String n014;
        int i29;
        String n015;
        int i30;
        String n016;
        int i31;
        String n017;
        int i32;
        String n018;
        int i33;
        String n019;
        int i34;
        Integer valueOf2;
        int i35;
        String n020;
        int i36;
        String n021;
        int i37;
        Long valueOf3;
        int i38;
        Long valueOf4;
        int i39;
        String n022;
        int i40;
        String n023;
        int i41;
        String n024;
        int i42;
        String n025;
        int i43;
        String n026;
        int i44;
        Integer valueOf5;
        int i45;
        String n027;
        int i46;
        Integer valueOf6;
        int i47;
        Integer valueOf7;
        int i48;
        Integer valueOf8;
        int i49;
        Integer valueOf9;
        int i50;
        String n028;
        int i51;
        String n029;
        int i52;
        String n030;
        int i53;
        String n031;
        int i54;
        int i55;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i56 = (int) D0.getLong(d22);
                int i57 = (int) D0.getLong(d23);
                int i58 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i59 = (int) D0.getLong(d27);
                int i60 = (int) D0.getLong(d28);
                int i61 = (int) D0.getLong(d29);
                int i62 = (int) D0.getLong(d30);
                int i63 = (int) D0.getLong(d31);
                int i64 = (int) D0.getLong(d32);
                int i65 = (int) D0.getLong(d33);
                int i66 = (int) D0.getLong(d34);
                int i67 = (int) D0.getLong(d35);
                int i68 = (int) D0.getLong(d36);
                int i69 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i11 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i11 = d39;
                }
                if (D0.isNull(i11)) {
                    i12 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d40;
                }
                if (D0.isNull(i12)) {
                    i13 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d41;
                }
                if (D0.isNull(i13)) {
                    i14 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d42;
                }
                long j14 = D0.getLong(i14);
                int i70 = (int) D0.getLong(d43);
                int i71 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i15 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i15 = d46;
                }
                if (D0.isNull(i15)) {
                    i16 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i15);
                    i16 = d47;
                }
                long j15 = D0.getLong(i16);
                if (D0.isNull(d48)) {
                    i17 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i17 = d49;
                }
                if (D0.isNull(i17)) {
                    i18 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i17);
                    i18 = d50;
                }
                long j16 = D0.getLong(i18);
                int i72 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i19 = i72;
                    i20 = d54;
                    n010 = null;
                } else {
                    i19 = i72;
                    n010 = D0.n0(d53);
                    i20 = d54;
                }
                int i73 = (int) D0.getLong(i20);
                if (D0.isNull(d55)) {
                    i21 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i21 = d56;
                }
                if (D0.isNull(i21)) {
                    i22 = i73;
                    i23 = d57;
                    n012 = null;
                } else {
                    i22 = i73;
                    n012 = D0.n0(i21);
                    i23 = d57;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d58;
                    z10 = true;
                } else {
                    i24 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d59;
                    z11 = true;
                } else {
                    i25 = d59;
                    z11 = false;
                }
                int i74 = (int) D0.getLong(i25);
                if (D0.isNull(d60)) {
                    i26 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i26 = d61;
                }
                if (D0.isNull(i26)) {
                    i27 = i74;
                    i28 = d62;
                    valueOf = null;
                } else {
                    i27 = i74;
                    valueOf = Integer.valueOf((int) D0.getLong(i26));
                    i28 = d62;
                }
                if (D0.isNull(i28)) {
                    i29 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i28);
                    i29 = d63;
                }
                if (D0.isNull(i29)) {
                    i30 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i29);
                    i30 = d64;
                }
                if (D0.isNull(i30)) {
                    i31 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i30);
                    i31 = d65;
                }
                if (D0.isNull(i31)) {
                    i32 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i31);
                    i32 = d66;
                }
                if (D0.isNull(i32)) {
                    i33 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i32);
                    i33 = d67;
                }
                if (D0.isNull(i33)) {
                    i34 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i33);
                    i34 = d68;
                }
                if (D0.isNull(i34)) {
                    i35 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i34));
                    i35 = d69;
                }
                if (D0.isNull(i35)) {
                    i36 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i35);
                    i36 = d70;
                }
                if (D0.isNull(i36)) {
                    i37 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i36);
                    i37 = d71;
                }
                if (D0.isNull(i37)) {
                    i38 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i37));
                    i38 = d72;
                }
                if (D0.isNull(i38)) {
                    i39 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i38));
                    i39 = d73;
                }
                if (D0.isNull(i39)) {
                    i40 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i39);
                    i40 = d74;
                }
                if (D0.isNull(i40)) {
                    i41 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i40);
                    i41 = d75;
                }
                if (D0.isNull(i41)) {
                    i42 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i41);
                    i42 = d76;
                }
                if (D0.isNull(i42)) {
                    i43 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i42);
                    i43 = d77;
                }
                if (D0.isNull(i43)) {
                    i44 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i43);
                    i44 = d78;
                }
                if (D0.isNull(i44)) {
                    i45 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i44));
                    i45 = d79;
                }
                if (D0.isNull(i45)) {
                    i46 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i45);
                    i46 = d80;
                }
                if (D0.isNull(i46)) {
                    i47 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i46));
                    i47 = d81;
                }
                if (D0.isNull(i47)) {
                    i48 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d82;
                }
                if (D0.isNull(i48)) {
                    i49 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d83;
                }
                if (D0.isNull(i49)) {
                    i50 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d84;
                }
                if (D0.isNull(i50)) {
                    i51 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i50);
                    i51 = d85;
                }
                if (D0.isNull(i51)) {
                    i52 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i51);
                    i52 = d86;
                }
                if (D0.isNull(i52)) {
                    i53 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i52);
                    i53 = d87;
                }
                if (D0.isNull(i53)) {
                    i54 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i53);
                    i54 = d88;
                }
                if (((int) D0.getLong(i54)) != 0) {
                    i55 = d89;
                    z12 = true;
                } else {
                    i55 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i56, i57, i58, j12, j13, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, n02, n03, n04, n05, j14, i70, i71, n06, n07, j15, n08, n09, j16, i19, j17, n010, i22, n011, n012, z10, z11, i27, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i55) ? null : D0.n0(i55), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List y0(String str, z3.b bVar) {
        String n02;
        int i11;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        int i17;
        String n07;
        int i18;
        String n08;
        int i19;
        String n09;
        int i20;
        int i21;
        String n010;
        int i22;
        String n011;
        int i23;
        int i24;
        int i25;
        String n012;
        int i26;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String n013;
        int i29;
        int i30;
        int i31;
        Integer valueOf;
        int i32;
        String n014;
        int i33;
        String n015;
        int i34;
        int i35;
        String n016;
        int i36;
        String n017;
        int i37;
        String n018;
        int i38;
        String n019;
        int i39;
        int i40;
        int i41;
        Integer valueOf2;
        int i42;
        String n020;
        int i43;
        String n021;
        int i44;
        int i45;
        Long valueOf3;
        int i46;
        Long valueOf4;
        int i47;
        String n022;
        int i48;
        String n023;
        int i49;
        String n024;
        int i50;
        String n025;
        int i51;
        String n026;
        int i52;
        int i53;
        int i54;
        Integer valueOf5;
        int i55;
        String n027;
        int i56;
        int i57;
        int i58;
        Integer valueOf6;
        int i59;
        int i60;
        int i61;
        Integer valueOf7;
        int i62;
        int i63;
        int i64;
        Integer valueOf8;
        int i65;
        int i66;
        int i67;
        Integer valueOf9;
        int i68;
        String n028;
        int i69;
        String n029;
        int i70;
        int i71;
        String n030;
        int i72;
        String n031;
        int i73;
        int i74;
        int i75;
        boolean z12;
        String n032;
        int i76;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY ep ASC ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n033 = D0.isNull(d11) ? null : D0.n0(d11);
                String n034 = D0.isNull(d12) ? null : D0.n0(d12);
                String n035 = D0.isNull(d13) ? null : D0.n0(d13);
                String n036 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n037 = D0.isNull(d16) ? null : D0.n0(d16);
                String n038 = D0.isNull(d17) ? null : D0.n0(d17);
                String n039 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i77 = d12;
                int i78 = d13;
                int i79 = (int) D0.getLong(d22);
                int i80 = d14;
                int i81 = (int) D0.getLong(d23);
                int i82 = d15;
                int i83 = (int) D0.getLong(d24);
                int i84 = d25;
                long j12 = D0.getLong(i84);
                int i85 = d11;
                int i86 = d26;
                long j13 = D0.getLong(i86);
                d26 = i86;
                int i87 = d27;
                int i88 = d16;
                int i89 = (int) D0.getLong(i87);
                int i90 = d18;
                int i91 = d28;
                int i92 = d17;
                int i93 = (int) D0.getLong(i91);
                int i94 = d20;
                int i95 = d29;
                int i96 = d19;
                int i97 = (int) D0.getLong(i95);
                int i98 = d22;
                int i99 = d30;
                int i100 = d21;
                int i101 = (int) D0.getLong(i99);
                int i102 = d24;
                int i103 = d31;
                int i104 = d23;
                int i105 = (int) D0.getLong(i103);
                int i106 = d32;
                int i107 = (int) D0.getLong(i106);
                int i108 = d33;
                int i109 = (int) D0.getLong(i108);
                int i110 = d34;
                int i111 = (int) D0.getLong(i110);
                int i112 = d35;
                int i113 = (int) D0.getLong(i112);
                int i114 = d36;
                int i115 = (int) D0.getLong(i114);
                int i116 = d37;
                int i117 = (int) D0.getLong(i116);
                int i118 = d38;
                if (D0.isNull(i118)) {
                    i11 = i87;
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(i118);
                    i11 = i87;
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    d39 = i12;
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    d39 = i12;
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    d40 = i13;
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    d40 = i13;
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    d41 = i14;
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    d41 = i14;
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                d42 = i15;
                int i119 = d43;
                int i120 = (int) D0.getLong(i119);
                int i121 = d44;
                int i122 = (int) D0.getLong(i121);
                int i123 = d45;
                if (D0.isNull(i123)) {
                    i16 = i119;
                    i17 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(i123);
                    i16 = i119;
                    i17 = d46;
                }
                if (D0.isNull(i17)) {
                    d46 = i17;
                    i18 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i17);
                    d46 = i17;
                    i18 = d47;
                }
                long j15 = D0.getLong(i18);
                d47 = i18;
                int i124 = d48;
                if (D0.isNull(i124)) {
                    d48 = i124;
                    i19 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(i124);
                    d48 = i124;
                    i19 = d49;
                }
                if (D0.isNull(i19)) {
                    d49 = i19;
                    i20 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i19);
                    d49 = i19;
                    i20 = d50;
                }
                long j16 = D0.getLong(i20);
                d50 = i20;
                int i125 = d51;
                int i126 = (int) D0.getLong(i125);
                int i127 = d52;
                long j17 = D0.getLong(i127);
                int i128 = d53;
                if (D0.isNull(i128)) {
                    d53 = i128;
                    i21 = i127;
                    i22 = d54;
                    n010 = null;
                } else {
                    i21 = i127;
                    n010 = D0.n0(i128);
                    d53 = i128;
                    i22 = d54;
                }
                int i129 = (int) D0.getLong(i22);
                int i130 = d55;
                if (D0.isNull(i130)) {
                    i23 = i22;
                    i24 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(i130);
                    i23 = i22;
                    i24 = d56;
                }
                if (D0.isNull(i24)) {
                    d56 = i24;
                    i25 = i130;
                    i26 = d57;
                    n012 = null;
                } else {
                    i25 = i130;
                    n012 = D0.n0(i24);
                    d56 = i24;
                    i26 = d57;
                }
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d58;
                    z10 = true;
                } else {
                    i27 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d59;
                    z11 = true;
                } else {
                    i28 = d59;
                    z11 = false;
                }
                int i131 = i27;
                int i132 = (int) D0.getLong(i28);
                int i133 = d60;
                if (D0.isNull(i133)) {
                    i29 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(i133);
                    i29 = d61;
                }
                if (D0.isNull(i29)) {
                    i30 = i132;
                    i31 = i133;
                    i32 = d62;
                    valueOf = null;
                } else {
                    i30 = i132;
                    i31 = i133;
                    valueOf = Integer.valueOf((int) D0.getLong(i29));
                    i32 = d62;
                }
                if (D0.isNull(i32)) {
                    i33 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i32);
                    i33 = d63;
                }
                if (D0.isNull(i33)) {
                    i34 = i26;
                    i35 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i33);
                    i34 = i26;
                    i35 = d64;
                }
                if (D0.isNull(i35)) {
                    d64 = i35;
                    i36 = d65;
                    n016 = null;
                } else {
                    d64 = i35;
                    n016 = D0.n0(i35);
                    i36 = d65;
                }
                if (D0.isNull(i36)) {
                    d65 = i36;
                    i37 = d66;
                    n017 = null;
                } else {
                    d65 = i36;
                    n017 = D0.n0(i36);
                    i37 = d66;
                }
                if (D0.isNull(i37)) {
                    d66 = i37;
                    i38 = d67;
                    n018 = null;
                } else {
                    d66 = i37;
                    n018 = D0.n0(i37);
                    i38 = d67;
                }
                if (D0.isNull(i38)) {
                    d67 = i38;
                    i39 = d68;
                    n019 = null;
                } else {
                    d67 = i38;
                    n019 = D0.n0(i38);
                    i39 = d68;
                }
                if (D0.isNull(i39)) {
                    i40 = i28;
                    i41 = i29;
                    i42 = d69;
                    valueOf2 = null;
                } else {
                    i40 = i28;
                    i41 = i29;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i39));
                    i42 = d69;
                }
                if (D0.isNull(i42)) {
                    i43 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i42);
                    i43 = d70;
                }
                if (D0.isNull(i43)) {
                    i44 = i39;
                    i45 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i43);
                    i44 = i39;
                    i45 = d71;
                }
                if (D0.isNull(i45)) {
                    d71 = i45;
                    i46 = d72;
                    valueOf3 = null;
                } else {
                    d71 = i45;
                    valueOf3 = Long.valueOf(D0.getLong(i45));
                    i46 = d72;
                }
                if (D0.isNull(i46)) {
                    d72 = i46;
                    i47 = d73;
                    valueOf4 = null;
                } else {
                    d72 = i46;
                    valueOf4 = Long.valueOf(D0.getLong(i46));
                    i47 = d73;
                }
                if (D0.isNull(i47)) {
                    d73 = i47;
                    i48 = d74;
                    n022 = null;
                } else {
                    d73 = i47;
                    n022 = D0.n0(i47);
                    i48 = d74;
                }
                if (D0.isNull(i48)) {
                    d74 = i48;
                    i49 = d75;
                    n023 = null;
                } else {
                    d74 = i48;
                    n023 = D0.n0(i48);
                    i49 = d75;
                }
                if (D0.isNull(i49)) {
                    d75 = i49;
                    i50 = d76;
                    n024 = null;
                } else {
                    d75 = i49;
                    n024 = D0.n0(i49);
                    i50 = d76;
                }
                if (D0.isNull(i50)) {
                    d76 = i50;
                    i51 = d77;
                    n025 = null;
                } else {
                    d76 = i50;
                    n025 = D0.n0(i50);
                    i51 = d77;
                }
                if (D0.isNull(i51)) {
                    d77 = i51;
                    i52 = d78;
                    n026 = null;
                } else {
                    d77 = i51;
                    n026 = D0.n0(i51);
                    i52 = d78;
                }
                if (D0.isNull(i52)) {
                    i53 = i42;
                    i54 = i43;
                    i55 = d79;
                    valueOf5 = null;
                } else {
                    i53 = i42;
                    i54 = i43;
                    valueOf5 = Integer.valueOf((int) D0.getLong(i52));
                    i55 = d79;
                }
                if (D0.isNull(i55)) {
                    i56 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i55);
                    i56 = d80;
                }
                if (D0.isNull(i56)) {
                    i57 = i32;
                    i58 = i33;
                    i59 = d81;
                    valueOf6 = null;
                } else {
                    i57 = i32;
                    i58 = i33;
                    valueOf6 = Integer.valueOf((int) D0.getLong(i56));
                    i59 = d81;
                }
                if (D0.isNull(i59)) {
                    i60 = i55;
                    i61 = i56;
                    i62 = d82;
                    valueOf7 = null;
                } else {
                    i60 = i55;
                    i61 = i56;
                    valueOf7 = Integer.valueOf((int) D0.getLong(i59));
                    i62 = d82;
                }
                if (D0.isNull(i62)) {
                    i63 = i59;
                    i64 = i60;
                    i65 = d83;
                    valueOf8 = null;
                } else {
                    i63 = i59;
                    i64 = i60;
                    valueOf8 = Integer.valueOf((int) D0.getLong(i62));
                    i65 = d83;
                }
                if (D0.isNull(i65)) {
                    i66 = i62;
                    i67 = i63;
                    i68 = d84;
                    valueOf9 = null;
                } else {
                    i66 = i62;
                    i67 = i63;
                    valueOf9 = Integer.valueOf((int) D0.getLong(i65));
                    i68 = d84;
                }
                if (D0.isNull(i68)) {
                    i69 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i68);
                    i69 = d85;
                }
                if (D0.isNull(i69)) {
                    i70 = i52;
                    i71 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i69);
                    i70 = i52;
                    i71 = d86;
                }
                if (D0.isNull(i71)) {
                    d86 = i71;
                    i72 = d87;
                    n030 = null;
                } else {
                    d86 = i71;
                    n030 = D0.n0(i71);
                    i72 = d87;
                }
                if (D0.isNull(i72)) {
                    d87 = i72;
                    i74 = i68;
                    i73 = d88;
                    n031 = null;
                } else {
                    d87 = i72;
                    n031 = D0.n0(i72);
                    i73 = d88;
                    i74 = i68;
                }
                int i134 = i69;
                if (((int) D0.getLong(i73)) != 0) {
                    i75 = d89;
                    z12 = true;
                } else {
                    i75 = d89;
                    z12 = false;
                }
                if (D0.isNull(i75)) {
                    i76 = d90;
                    n032 = null;
                } else {
                    n032 = D0.n0(i75);
                    i76 = d90;
                }
                int i135 = i73;
                arrayList.add(new DownloadBean(n033, n034, n035, n036, valueOf10, n037, n038, n039, valueOf11, valueOf12, j11, i79, i81, i83, j12, j13, i89, i93, i97, i101, i105, i107, i109, i111, i113, i115, i117, n02, n03, n04, n05, j14, i120, i122, n06, n07, j15, n08, n09, j16, i126, j17, n010, i129, n011, n012, z10, z11, i30, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, n032, D0.isNull(i76) ? null : D0.n0(i76)));
                d11 = i85;
                d89 = i75;
                d90 = i76;
                d17 = i92;
                d19 = i96;
                d21 = i100;
                d30 = i99;
                d43 = i16;
                d51 = i125;
                d54 = i23;
                d58 = i131;
                d57 = i34;
                d59 = i40;
                d61 = i41;
                d68 = i44;
                d69 = i53;
                d70 = i54;
                d62 = i57;
                d63 = i58;
                d80 = i61;
                d79 = i64;
                d81 = i67;
                d78 = i70;
                d84 = i74;
                d85 = i134;
                d12 = i77;
                d13 = i78;
                d14 = i80;
                d15 = i82;
                d25 = i84;
                d20 = i94;
                d22 = i98;
                d33 = i108;
                d35 = i112;
                d36 = i114;
                d37 = i116;
                d45 = i123;
                d52 = i21;
                d55 = i25;
                d44 = i121;
                d28 = i91;
                d29 = i95;
                d83 = i65;
                d82 = i66;
                d16 = i88;
                d23 = i104;
                d31 = i103;
                d32 = i106;
                d27 = i11;
                d88 = i135;
                d18 = i90;
                d24 = i102;
                d34 = i110;
                d38 = i118;
                d60 = i31;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean z0(String str, int i11, z3.b bVar) {
        String n02;
        int i12;
        String n03;
        int i13;
        String n04;
        int i14;
        String n05;
        int i15;
        String n06;
        int i16;
        String n07;
        int i17;
        String n08;
        int i18;
        String n09;
        int i19;
        int i20;
        String n010;
        int i21;
        String n011;
        int i22;
        int i23;
        String n012;
        int i24;
        int i25;
        boolean z10;
        int i26;
        boolean z11;
        String n013;
        int i27;
        int i28;
        Integer valueOf;
        int i29;
        String n014;
        int i30;
        String n015;
        int i31;
        String n016;
        int i32;
        String n017;
        int i33;
        String n018;
        int i34;
        String n019;
        int i35;
        Integer valueOf2;
        int i36;
        String n020;
        int i37;
        String n021;
        int i38;
        Long valueOf3;
        int i39;
        Long valueOf4;
        int i40;
        String n022;
        int i41;
        String n023;
        int i42;
        String n024;
        int i43;
        String n025;
        int i44;
        String n026;
        int i45;
        Integer valueOf5;
        int i46;
        String n027;
        int i47;
        Integer valueOf6;
        int i48;
        Integer valueOf7;
        int i49;
        Integer valueOf8;
        int i50;
        Integer valueOf9;
        int i51;
        String n028;
        int i52;
        String n029;
        int i53;
        String n030;
        int i54;
        String n031;
        int i55;
        int i56;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep =? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            int d11 = androidx.room.util.k.d(D0, "url");
            int d12 = androidx.room.util.k.d(D0, "resourceId");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "cover");
            int d15 = androidx.room.util.k.d(D0, "size");
            int d16 = androidx.room.util.k.d(D0, "postId");
            int d17 = androidx.room.util.k.d(D0, "sizeFormat");
            int d18 = androidx.room.util.k.d(D0, "path");
            int d19 = androidx.room.util.k.d(D0, "duration");
            int d20 = androidx.room.util.k.d(D0, "updateTimeStamp");
            int d21 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d22 = androidx.room.util.k.d(D0, "supportRanges");
            int d23 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d24 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d25 = androidx.room.util.k.d(D0, "readProgress");
            int d26 = androidx.room.util.k.d(D0, "createAt");
            int d27 = androidx.room.util.k.d(D0, "isRead");
            int d28 = androidx.room.util.k.d(D0, "episode");
            int d29 = androidx.room.util.k.d(D0, "ep");
            int d30 = androidx.room.util.k.d(D0, "se");
            int d31 = androidx.room.util.k.d(D0, "resolution");
            int d32 = androidx.room.util.k.d(D0, "resourcePosition");
            int d33 = androidx.room.util.k.d(D0, "multiresolution");
            int d34 = androidx.room.util.k.d(D0, "videoWidth");
            int d35 = androidx.room.util.k.d(D0, "videoHeight");
            int d36 = androidx.room.util.k.d(D0, "downloadErrorCount");
            int d37 = androidx.room.util.k.d(D0, "subtitleStarted");
            int d38 = androidx.room.util.k.d(D0, "subjectId");
            int d39 = androidx.room.util.k.d(D0, "pageFrom");
            int d40 = androidx.room.util.k.d(D0, "lastPageFrom");
            int d41 = androidx.room.util.k.d(D0, "subjectName");
            int d42 = androidx.room.util.k.d(D0, "lastPlayTimeStamp");
            int d43 = androidx.room.util.k.d(D0, "fileType");
            int d44 = androidx.room.util.k.d(D0, "totalEpisode");
            int d45 = androidx.room.util.k.d(D0, "uploadBy");
            int d46 = androidx.room.util.k.d(D0, "sourceUrl");
            int d47 = androidx.room.util.k.d(D0, "urlCreateAt");
            int d48 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d49 = androidx.room.util.k.d(D0, "taskId");
            int d50 = androidx.room.util.k.d(D0, "sessionTime");
            int d51 = androidx.room.util.k.d(D0, "reportStatus");
            int d52 = androidx.room.util.k.d(D0, "downloadHeaderSize");
            int d53 = androidx.room.util.k.d(D0, "rootPath");
            int d54 = androidx.room.util.k.d(D0, "rootPathType");
            int d55 = androidx.room.util.k.d(D0, "thumbnail");
            int d56 = androidx.room.util.k.d(D0, "averageHueLight");
            int d57 = androidx.room.util.k.d(D0, "isTransferFailed");
            int d58 = androidx.room.util.k.d(D0, "isClosedTransferFailed");
            int d59 = androidx.room.util.k.d(D0, "subjectType");
            int d60 = androidx.room.util.k.d(D0, "genre");
            int d61 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d62 = androidx.room.util.k.d(D0, "currentDubLanName");
            int d63 = androidx.room.util.k.d(D0, "currentDubLanCode");
            int d64 = androidx.room.util.k.d(D0, "ops");
            int d65 = androidx.room.util.k.d(D0, "restrictLevel");
            int d66 = androidx.room.util.k.d(D0, "releaseDate");
            int d67 = androidx.room.util.k.d(D0, "countryName");
            int d68 = androidx.room.util.k.d(D0, "seNum");
            int d69 = androidx.room.util.k.d(D0, "subtitles");
            int d70 = androidx.room.util.k.d(D0, "imdbRate");
            int d71 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d72 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d73 = androidx.room.util.k.d(D0, "subtitleIdType");
            int d74 = androidx.room.util.k.d(D0, "ugcVideoCollectionId");
            int d75 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d76 = androidx.room.util.k.d(D0, "ugcVideoName");
            int d77 = androidx.room.util.k.d(D0, "ugcVideoCollectionName");
            int d78 = androidx.room.util.k.d(D0, "ugcVideoPosition");
            int d79 = androidx.room.util.k.d(D0, "ugcVideoType");
            int d80 = androidx.room.util.k.d(D0, "ugcCateLev1Id");
            int d81 = androidx.room.util.k.d(D0, "ugcCateLev2Id");
            int d82 = androidx.room.util.k.d(D0, "ugcCateLev3Id");
            int d83 = androidx.room.util.k.d(D0, "ugcCateLev4Id");
            int d84 = androidx.room.util.k.d(D0, "ugcVideoTrackId");
            int d85 = androidx.room.util.k.d(D0, "ugcVideoParentVideoId");
            int d86 = androidx.room.util.k.d(D0, "ugcVideoParentTrackId");
            int d87 = androidx.room.util.k.d(D0, "ugcVideoEpTitle");
            int d88 = androidx.room.util.k.d(D0, "ugcVideoIsVertical");
            int d89 = androidx.room.util.k.d(D0, "originData");
            int d90 = androidx.room.util.k.d(D0, "kidId");
            DownloadBean downloadBean = null;
            if (D0.A0()) {
                String n032 = D0.isNull(d11) ? null : D0.n0(d11);
                String n033 = D0.isNull(d12) ? null : D0.n0(d12);
                String n034 = D0.isNull(d13) ? null : D0.n0(d13);
                String n035 = D0.isNull(d14) ? null : D0.n0(d14);
                Long valueOf10 = D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15));
                String n036 = D0.isNull(d16) ? null : D0.n0(d16);
                String n037 = D0.isNull(d17) ? null : D0.n0(d17);
                String n038 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf11 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf12 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                long j11 = D0.getLong(d21);
                int i57 = (int) D0.getLong(d22);
                int i58 = (int) D0.getLong(d23);
                int i59 = (int) D0.getLong(d24);
                long j12 = D0.getLong(d25);
                long j13 = D0.getLong(d26);
                int i60 = (int) D0.getLong(d27);
                int i61 = (int) D0.getLong(d28);
                int i62 = (int) D0.getLong(d29);
                int i63 = (int) D0.getLong(d30);
                int i64 = (int) D0.getLong(d31);
                int i65 = (int) D0.getLong(d32);
                int i66 = (int) D0.getLong(d33);
                int i67 = (int) D0.getLong(d34);
                int i68 = (int) D0.getLong(d35);
                int i69 = (int) D0.getLong(d36);
                int i70 = (int) D0.getLong(d37);
                if (D0.isNull(d38)) {
                    i12 = d39;
                    n02 = null;
                } else {
                    n02 = D0.n0(d38);
                    i12 = d39;
                }
                if (D0.isNull(i12)) {
                    i13 = d40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i12);
                    i13 = d40;
                }
                if (D0.isNull(i13)) {
                    i14 = d41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i13);
                    i14 = d41;
                }
                if (D0.isNull(i14)) {
                    i15 = d42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i14);
                    i15 = d42;
                }
                long j14 = D0.getLong(i15);
                int i71 = (int) D0.getLong(d43);
                int i72 = (int) D0.getLong(d44);
                if (D0.isNull(d45)) {
                    i16 = d46;
                    n06 = null;
                } else {
                    n06 = D0.n0(d45);
                    i16 = d46;
                }
                if (D0.isNull(i16)) {
                    i17 = d47;
                    n07 = null;
                } else {
                    n07 = D0.n0(i16);
                    i17 = d47;
                }
                long j15 = D0.getLong(i17);
                if (D0.isNull(d48)) {
                    i18 = d49;
                    n08 = null;
                } else {
                    n08 = D0.n0(d48);
                    i18 = d49;
                }
                if (D0.isNull(i18)) {
                    i19 = d50;
                    n09 = null;
                } else {
                    n09 = D0.n0(i18);
                    i19 = d50;
                }
                long j16 = D0.getLong(i19);
                int i73 = (int) D0.getLong(d51);
                long j17 = D0.getLong(d52);
                if (D0.isNull(d53)) {
                    i20 = i73;
                    i21 = d54;
                    n010 = null;
                } else {
                    i20 = i73;
                    n010 = D0.n0(d53);
                    i21 = d54;
                }
                int i74 = (int) D0.getLong(i21);
                if (D0.isNull(d55)) {
                    i22 = d56;
                    n011 = null;
                } else {
                    n011 = D0.n0(d55);
                    i22 = d56;
                }
                if (D0.isNull(i22)) {
                    i23 = i74;
                    i24 = d57;
                    n012 = null;
                } else {
                    i23 = i74;
                    n012 = D0.n0(i22);
                    i24 = d57;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d58;
                    z10 = true;
                } else {
                    i25 = d58;
                    z10 = false;
                }
                if (((int) D0.getLong(i25)) != 0) {
                    i26 = d59;
                    z11 = true;
                } else {
                    i26 = d59;
                    z11 = false;
                }
                int i75 = (int) D0.getLong(i26);
                if (D0.isNull(d60)) {
                    i27 = d61;
                    n013 = null;
                } else {
                    n013 = D0.n0(d60);
                    i27 = d61;
                }
                if (D0.isNull(i27)) {
                    i28 = i75;
                    i29 = d62;
                    valueOf = null;
                } else {
                    i28 = i75;
                    valueOf = Integer.valueOf((int) D0.getLong(i27));
                    i29 = d62;
                }
                if (D0.isNull(i29)) {
                    i30 = d63;
                    n014 = null;
                } else {
                    n014 = D0.n0(i29);
                    i30 = d63;
                }
                if (D0.isNull(i30)) {
                    i31 = d64;
                    n015 = null;
                } else {
                    n015 = D0.n0(i30);
                    i31 = d64;
                }
                if (D0.isNull(i31)) {
                    i32 = d65;
                    n016 = null;
                } else {
                    n016 = D0.n0(i31);
                    i32 = d65;
                }
                if (D0.isNull(i32)) {
                    i33 = d66;
                    n017 = null;
                } else {
                    n017 = D0.n0(i32);
                    i33 = d66;
                }
                if (D0.isNull(i33)) {
                    i34 = d67;
                    n018 = null;
                } else {
                    n018 = D0.n0(i33);
                    i34 = d67;
                }
                if (D0.isNull(i34)) {
                    i35 = d68;
                    n019 = null;
                } else {
                    n019 = D0.n0(i34);
                    i35 = d68;
                }
                if (D0.isNull(i35)) {
                    i36 = d69;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) D0.getLong(i35));
                    i36 = d69;
                }
                if (D0.isNull(i36)) {
                    i37 = d70;
                    n020 = null;
                } else {
                    n020 = D0.n0(i36);
                    i37 = d70;
                }
                if (D0.isNull(i37)) {
                    i38 = d71;
                    n021 = null;
                } else {
                    n021 = D0.n0(i37);
                    i38 = d71;
                }
                if (D0.isNull(i38)) {
                    i39 = d72;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i38));
                    i39 = d72;
                }
                if (D0.isNull(i39)) {
                    i40 = d73;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(i39));
                    i40 = d73;
                }
                if (D0.isNull(i40)) {
                    i41 = d74;
                    n022 = null;
                } else {
                    n022 = D0.n0(i40);
                    i41 = d74;
                }
                if (D0.isNull(i41)) {
                    i42 = d75;
                    n023 = null;
                } else {
                    n023 = D0.n0(i41);
                    i42 = d75;
                }
                if (D0.isNull(i42)) {
                    i43 = d76;
                    n024 = null;
                } else {
                    n024 = D0.n0(i42);
                    i43 = d76;
                }
                if (D0.isNull(i43)) {
                    i44 = d77;
                    n025 = null;
                } else {
                    n025 = D0.n0(i43);
                    i44 = d77;
                }
                if (D0.isNull(i44)) {
                    i45 = d78;
                    n026 = null;
                } else {
                    n026 = D0.n0(i44);
                    i45 = d78;
                }
                if (D0.isNull(i45)) {
                    i46 = d79;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) D0.getLong(i45));
                    i46 = d79;
                }
                if (D0.isNull(i46)) {
                    i47 = d80;
                    n027 = null;
                } else {
                    n027 = D0.n0(i46);
                    i47 = d80;
                }
                if (D0.isNull(i47)) {
                    i48 = d81;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) D0.getLong(i47));
                    i48 = d81;
                }
                if (D0.isNull(i48)) {
                    i49 = d82;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) D0.getLong(i48));
                    i49 = d82;
                }
                if (D0.isNull(i49)) {
                    i50 = d83;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) D0.getLong(i49));
                    i50 = d83;
                }
                if (D0.isNull(i50)) {
                    i51 = d84;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) D0.getLong(i50));
                    i51 = d84;
                }
                if (D0.isNull(i51)) {
                    i52 = d85;
                    n028 = null;
                } else {
                    n028 = D0.n0(i51);
                    i52 = d85;
                }
                if (D0.isNull(i52)) {
                    i53 = d86;
                    n029 = null;
                } else {
                    n029 = D0.n0(i52);
                    i53 = d86;
                }
                if (D0.isNull(i53)) {
                    i54 = d87;
                    n030 = null;
                } else {
                    n030 = D0.n0(i53);
                    i54 = d87;
                }
                if (D0.isNull(i54)) {
                    i55 = d88;
                    n031 = null;
                } else {
                    n031 = D0.n0(i54);
                    i55 = d88;
                }
                if (((int) D0.getLong(i55)) != 0) {
                    i56 = d89;
                    z12 = true;
                } else {
                    i56 = d89;
                    z12 = false;
                }
                downloadBean = new DownloadBean(n032, n033, n034, n035, valueOf10, n036, n037, n038, valueOf11, valueOf12, j11, i57, i58, i59, j12, j13, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, i70, n02, n03, n04, n05, j14, i71, i72, n06, n07, j15, n08, n09, j16, i20, j17, n010, i23, n011, n012, z10, z11, i28, n013, valueOf, n014, n015, n016, n017, n018, n019, valueOf2, n020, n021, valueOf3, valueOf4, n022, n023, n024, n025, n026, valueOf5, n027, valueOf6, valueOf7, valueOf8, valueOf9, n028, n029, n030, n031, z12, D0.isNull(i56) ? null : D0.n0(i56), D0.isNull(d90) ? null : D0.n0(d90));
            }
            D0.close();
            return downloadBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // lj.c
    public Object A(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List O0;
                O0 = l0.O0(str, (z3.b) obj);
                return O0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object B(final String str, final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean w02;
                w02 = l0.w0(str, i11, (z3.b) obj);
                return w02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object C(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean G0;
                G0 = l0.G0((z3.b) obj);
                return G0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object D(final String str, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = l0.S0(j11, str, (z3.b) obj);
                return S0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object E(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean x02;
                x02 = l0.x0(str, (z3.b) obj);
                return x02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object F(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean L0;
                L0 = l0.L0(str, i11, i12, (z3.b) obj);
                return L0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object G(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean H0;
                H0 = l0.H0(str, (z3.b) obj);
                return H0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object H(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List y02;
                y02 = l0.y0(str, (z3.b) obj);
                return y02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object I(final String str, final String str2, final String str3, final String str4, final Integer num, final String str5, final String str6, final String str7, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = l0.W0(str2, str3, str4, str6, num, str5, str7, str, (z3.b) obj);
                return W0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = l0.X0(str2, str, (z3.b) obj);
                return X0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object c(final String str, final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = l0.V0(i11, str, (z3.b) obj);
                return V0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s02;
                s02 = l0.s0(str, (z3.b) obj);
                return s02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List J0;
                J0 = l0.J0(str, (z3.b) obj);
                return J0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean v02;
                v02 = l0.v0(str, (z3.b) obj);
                return v02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List K0;
                K0 = l0.K0(str, (z3.b) obj);
                return K0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object h(final String str, final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean z02;
                z02 = l0.z0(str, i11, (z3.b) obj);
                return z02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object i(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List D0;
                D0 = l0.D0((z3.b) obj);
                return D0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object j(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = l0.Y0(i11, i12, str, (z3.b) obj);
                return Y0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object k(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean P0;
                P0 = l0.P0(str, (z3.b) obj);
                return P0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object l(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List N0;
                N0 = l0.N0((z3.b) obj);
                return N0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object m(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List F0;
                F0 = l0.F0((z3.b) obj);
                return F0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object n(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t02;
                t02 = l0.t0(str, (z3.b) obj);
                return t02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object o(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r02;
                r02 = l0.r0(str, (z3.b) obj);
                return r02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object p(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List M0;
                M0 = l0.M0((z3.b) obj);
                return M0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object q(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List u02;
                u02 = l0.u0(str, (z3.b) obj);
                return u02;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object r(final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List I0;
                I0 = l0.I0(i11, (z3.b) obj);
                return I0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object s(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List A0;
                A0 = l0.A0((z3.b) obj);
                return A0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object t(final String str, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = l0.U0(j11, str, (z3.b) obj);
                return U0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object u(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List C0;
                C0 = l0.C0(str, (z3.b) obj);
                return C0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object v(final DownloadBean downloadBean, Continuation continuation) {
        downloadBean.getClass();
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = l0.this.Q0(downloadBean, (z3.b) obj);
                return Q0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object w(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List E0;
                E0 = l0.E0(str, (z3.b) obj);
                return E0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object x(final String str, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = l0.T0(j11, str, (z3.b) obj);
                return T0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object y(Continuation continuation) {
        return androidx.room.util.b.f(this.f69030a, true, false, new Function1() { // from class: lj.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadBean B0;
                B0 = l0.B0((z3.b) obj);
                return B0;
            }
        }, continuation);
    }

    @Override // lj.c
    public Object z(final DownloadBean downloadBean, Continuation continuation) {
        downloadBean.getClass();
        return androidx.room.util.b.f(this.f69030a, false, true, new Function1() { // from class: lj.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = l0.this.R0(downloadBean, (z3.b) obj);
                return R0;
            }
        }, continuation);
    }
}
