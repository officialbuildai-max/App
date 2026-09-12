package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Range;
import com.alibaba.sdk.android.oss.model.ResumableDownloadRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ResumableDownloadTask<Requst extends ResumableDownloadRequest, Result extends ResumableDownloadResult> implements Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected String checkpointPath;
    protected long completedPartSize;
    protected long downloadPartSize;
    private CheckPoint mCheckPoint;
    private OSSCompletedCallback mCompletedCallback;
    private ExecutionContext mContext;
    protected Exception mDownloadException;
    protected Object mLock;
    private InternalRequestOperation mOperation;
    protected long mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    private OSSProgressCallback mProgressCallback;
    private ResumableDownloadRequest mRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class CheckPoint implements Serializable {
        private static final long serialVersionUID = -8470273912385636504L;
        public String bucketName;
        public String downloadFile;
        public long downloadLength;
        public FileStat fileStat;
        public int md5;
        public String objectKey;
        public ArrayList<DownloadPart> parts;

        CheckPoint() {
        }

        private void assign(CheckPoint checkPoint) {
            this.md5 = checkPoint.md5;
            this.downloadFile = checkPoint.downloadFile;
            this.bucketName = checkPoint.bucketName;
            this.objectKey = checkPoint.objectKey;
            this.fileStat = checkPoint.fileStat;
            this.parts = checkPoint.parts;
            this.downloadLength = checkPoint.downloadLength;
        }

        public synchronized void dump(String str) throws IOException {
            FileOutputStream fileOutputStream;
            Throwable th2;
            ObjectOutputStream objectOutputStream;
            this.md5 = hashCode();
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (Throwable th3) {
                    th2 = th3;
                    objectOutputStream = null;
                }
            } catch (Throwable th4) {
                fileOutputStream = null;
                th2 = th4;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(this);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Throwable th5) {
                th2 = th5;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th2;
            }
        }

        public int hashCode() {
            String str = this.bucketName;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.downloadFile;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.objectKey;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            FileStat fileStat = this.fileStat;
            int hashCode4 = (hashCode3 + (fileStat == null ? 0 : fileStat.hashCode())) * 31;
            ArrayList<DownloadPart> arrayList = this.parts;
            int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
            long j11 = this.downloadLength;
            return hashCode5 + ((int) (j11 ^ (j11 >>> 32)));
        }

        public synchronized boolean isValid(InternalRequestOperation internalRequestOperation) throws ClientException, ServiceException {
            if (this.md5 != hashCode()) {
                return false;
            }
            FileStat fileStat = FileStat.getFileStat(internalRequestOperation, this.bucketName, this.objectKey);
            FileStat fileStat2 = this.fileStat;
            Date date = fileStat2.lastModified;
            if (date == null) {
                if (fileStat2.fileLength != fileStat.fileLength || !fileStat2.etag.equals(fileStat.etag)) {
                    return false;
                }
            } else if (fileStat2.fileLength != fileStat.fileLength || !date.equals(fileStat.lastModified) || !this.fileStat.etag.equals(fileStat.etag)) {
                return false;
            }
            return true;
        }

        public synchronized void load(String str) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream;
            Throwable th2;
            ObjectInputStream objectInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (Throwable th3) {
                    th2 = th3;
                    objectInputStream = null;
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th2 = th4;
                objectInputStream = null;
            }
            try {
                assign((CheckPoint) objectInputStream.readObject());
                objectInputStream.close();
                fileInputStream.close();
            } catch (Throwable th5) {
                th2 = th5;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        }

        public synchronized void update(int i11, boolean z10) throws IOException {
            this.parts.get(i11).isCompleted = z10;
            this.downloadLength += this.parts.get(i11).length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class DownloadFileResult extends OSSResult {
        public ObjectMetadata metadata;
        public ArrayList<DownloadPartResult> partResults;

        DownloadFileResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DownloadPart implements Serializable {
        private static final long serialVersionUID = -3506020776131733942L;
        public long crc;
        public long end;
        public long fileStart;
        public boolean isCompleted;
        public long length;
        public int partNumber;
        public long start;

        DownloadPart() {
        }

        public int hashCode() {
            int i11 = (((this.partNumber + 31) * 31) + (this.isCompleted ? 1231 : 1237)) * 31;
            long j11 = this.end;
            int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.start;
            long j13 = this.crc;
            return ((i12 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DownloadPartResult {
        public Long clientCRC;
        public long length;
        public int partNumber;
        public String requestId;

        DownloadPartResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FileStat implements Serializable {
        private static final long serialVersionUID = 3896323364904643963L;
        public String etag;
        public long fileLength;
        public Date lastModified;
        public String md5;
        public String requestId;
        public Long serverCRC;

        FileStat() {
        }

        public static FileStat getFileStat(InternalRequestOperation internalRequestOperation, String str, String str2) throws ClientException, ServiceException {
            HeadObjectResult result = internalRequestOperation.headObject(new HeadObjectRequest(str, str2), null).getResult();
            FileStat fileStat = new FileStat();
            fileStat.fileLength = result.getMetadata().getContentLength();
            fileStat.etag = result.getMetadata().getETag();
            fileStat.lastModified = result.getMetadata().getLastModified();
            fileStat.serverCRC = result.getServerCRC();
            fileStat.requestId = result.getRequestId();
            return fileStat;
        }

        public int hashCode() {
            String str = this.etag;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Date date = this.lastModified;
            int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
            long j11 = this.fileLength;
            return hashCode2 + ((int) (j11 ^ (j11 >>> 32)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumableDownloadTask(InternalRequestOperation internalRequestOperation, ResumableDownloadRequest resumableDownloadRequest, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i11 = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i11;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(i11, availableProcessors, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mLock = new Object();
        this.mRequest = resumableDownloadRequest;
        this.mOperation = internalRequestOperation;
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mProgressCallback = resumableDownloadRequest.getProgressListener();
    }

    private static Long calcObjectCRCFromParts(List<DownloadPartResult> list) {
        long j11 = 0;
        for (DownloadPartResult downloadPartResult : list) {
            Long l11 = downloadPartResult.clientCRC;
            if (l11 == null || downloadPartResult.length <= 0) {
                return null;
            }
            j11 = CRC64.combine(j11, l11.longValue(), downloadPartResult.length);
        }
        return new Long(j11);
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private Range correctRange(Range range, long j11) {
        if (range != null) {
            r0 = range.getBegin() != -1 ? range.getBegin() : 0L;
            j11 = range.getEnd() == -1 ? j11 - r0 : range.getEnd() - range.getBegin();
        }
        return new Range(r0, j11 + r0);
    }

    private void createFile(String str, long j11) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th2;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "rw");
            try {
                randomAccessFile.setLength(j11);
                randomAccessFile.close();
            } catch (Throwable th3) {
                th2 = th3;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            randomAccessFile = null;
            th2 = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018b A[Catch: IOException -> 0x0187, TRY_LEAVE, TryCatch #1 {IOException -> 0x0187, blocks: (B:70:0x0183, B:63:0x018b), top: B:69:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask<Requst, Result>.DownloadFileResult r13, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart r14) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPart):void");
    }

    private void initCheckPoint() throws ClientException, ServiceException, IOException {
        FileStat fileStat = FileStat.getFileStat(this.mOperation, this.mRequest.getBucketName(), this.mRequest.getObjectKey());
        Range correctRange = correctRange(this.mRequest.getRange(), fileStat.fileLength);
        createFile(this.mRequest.getTempFilePath(), correctRange.getEnd() - correctRange.getBegin());
        this.mCheckPoint.bucketName = this.mRequest.getBucketName();
        this.mCheckPoint.objectKey = this.mRequest.getObjectKey();
        CheckPoint checkPoint = this.mCheckPoint;
        checkPoint.fileStat = fileStat;
        checkPoint.parts = splitFile(correctRange, fileStat.fileLength, this.mRequest.getPartSize());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void moveFile(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r5.renameTo(r6)
            if (r0 != 0) goto L5b
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.io.FileNotFoundException -> L4c
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L49 java.io.FileNotFoundException -> L4c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L46
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L46
            r4.copyFile(r1, r2)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            boolean r6 = r5.delete()     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            if (r6 == 0) goto L21
            r1.close()
            r2.close()
            goto L5b
        L21:
            java.io.IOException r6 = new java.io.IOException     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            r0.<init>()     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            java.lang.String r3 = "Failed to delete original file '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            r0.append(r5)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            java.lang.String r5 = "'"
            r0.append(r5)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
            throw r6     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L40
        L3d:
            r5 = move-exception
        L3e:
            r0 = r1
            goto L50
        L40:
            r5 = move-exception
        L41:
            r0 = r1
            goto L4e
        L43:
            r5 = move-exception
            r2 = r0
            goto L3e
        L46:
            r5 = move-exception
            r2 = r0
            goto L41
        L49:
            r5 = move-exception
            r2 = r0
            goto L50
        L4c:
            r5 = move-exception
            r2 = r0
        L4e:
            throw r5     // Catch: java.lang.Throwable -> L4f
        L4f:
            r5 = move-exception
        L50:
            if (r0 == 0) goto L55
            r0.close()
        L55:
            if (r2 == 0) goto L5a
            r2.close()
        L5a:
            throw r5
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.moveFile(java.io.File, java.io.File):void");
    }

    private ArrayList<DownloadPart> splitFile(Range range, long j11, long j12) {
        long j13;
        int i11 = 0;
        if (j11 <= 0) {
            DownloadPart downloadPart = new DownloadPart();
            downloadPart.start = 0L;
            downloadPart.end = -1L;
            downloadPart.length = 0L;
            downloadPart.partNumber = 0;
            ArrayList<DownloadPart> arrayList = new ArrayList<>();
            arrayList.add(downloadPart);
            return arrayList;
        }
        long begin = range.getBegin();
        long end = range.getEnd() - range.getBegin();
        long j14 = end / j12;
        if (end % j12 > 0) {
            j14++;
        }
        ArrayList<DownloadPart> arrayList2 = new ArrayList<>();
        while (true) {
            long j15 = i11;
            if (j15 >= j14) {
                return arrayList2;
            }
            DownloadPart downloadPart2 = new DownloadPart();
            long j16 = j15 * j12;
            long j17 = begin + j16;
            downloadPart2.start = j17;
            int i12 = i11 + 1;
            long j18 = ((i12 * j12) + begin) - 1;
            downloadPart2.end = j18;
            long j19 = j14;
            downloadPart2.length = (j18 - j17) + 1;
            long j20 = begin + end;
            if (j18 >= j20) {
                j13 = -1;
                downloadPart2.end = -1L;
                downloadPart2.length = j20 - j17;
            } else {
                j13 = -1;
            }
            downloadPart2.partNumber = i11;
            downloadPart2.fileStart = j16;
            arrayList2.add(downloadPart2);
            i11 = i12;
            j14 = j19;
        }
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            Result result = (Result) doMultipartDownload();
            OSSCompletedCallback oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e11) {
            OSSCompletedCallback oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e11);
            }
            throw e11;
        } catch (Exception e12) {
            ClientException clientException = e12 instanceof ClientException ? (ClientException) e12 : new ClientException(e12.toString(), e12);
            OSSCompletedCallback oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    protected void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("Resumable download cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
        }
    }

    protected void checkException() throws IOException, ServiceException, ClientException {
        if (this.mDownloadException != null) {
            releasePool();
            Exception exc = this.mDownloadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(this.mDownloadException.getMessage(), this.mDownloadException);
            }
            throw ((ClientException) exc);
        }
    }

    protected void checkInitData() throws ClientException, ServiceException, IOException {
        if (this.mRequest.getRange() != null && !this.mRequest.getRange().checkIsValid()) {
            throw new ClientException("Range is invalid");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mRequest.getBucketName());
        sb2.append(this.mRequest.getObjectKey());
        sb2.append(String.valueOf(this.mRequest.getPartSize()));
        sb2.append(this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES ? "-crc64" : "");
        this.checkpointPath = this.mRequest.getCheckPointFilePath() + File.separator + BinaryUtil.calculateMd5Str(sb2.toString().getBytes());
        this.mCheckPoint = new CheckPoint();
        if (!this.mRequest.getEnableCheckPoint().booleanValue()) {
            initCheckPoint();
            return;
        }
        try {
            this.mCheckPoint.load(this.checkpointPath);
        } catch (Exception unused) {
            removeFile(this.checkpointPath);
            removeFile(this.mRequest.getTempFilePath());
        }
        if (this.mCheckPoint.isValid(this.mOperation)) {
            return;
        }
        removeFile(this.checkpointPath);
        removeFile(this.mRequest.getTempFilePath());
        initCheckPoint();
    }

    protected boolean checkWaitCondition(int i11) {
        return this.completedPartSize != ((long) i11);
    }

    protected ResumableDownloadResult doMultipartDownload() throws ClientException, ServiceException, IOException, InterruptedException {
        checkCancel();
        ResumableDownloadResult resumableDownloadResult = new ResumableDownloadResult();
        final DownloadFileResult downloadFileResult = new DownloadFileResult();
        downloadFileResult.partResults = new ArrayList<>();
        Iterator<DownloadPart> it = this.mCheckPoint.parts.iterator();
        while (it.hasNext()) {
            final DownloadPart next = it.next();
            checkException();
            ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
            if (threadPoolExecutor == null || next.isCompleted) {
                DownloadPartResult downloadPartResult = new DownloadPartResult();
                downloadPartResult.partNumber = next.partNumber;
                downloadPartResult.requestId = this.mCheckPoint.fileStat.requestId;
                downloadPartResult.length = next.length;
                if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES) {
                    downloadPartResult.clientCRC = Long.valueOf(next.crc);
                }
                downloadFileResult.partResults.add(downloadPartResult);
                this.downloadPartSize++;
                this.completedPartSize++;
            } else {
                threadPoolExecutor.execute(new Runnable() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ResumableDownloadTask.this.downloadPart(downloadFileResult, next);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("start: ");
                        sb2.append(next.start);
                        sb2.append(", end: ");
                        sb2.append(next.end);
                    }
                });
            }
        }
        if (checkWaitCondition(this.mCheckPoint.parts.size())) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        Collections.sort(downloadFileResult.partResults, new Comparator<DownloadPartResult>() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.3
            @Override // java.util.Comparator
            public int compare(DownloadPartResult downloadPartResult2, DownloadPartResult downloadPartResult3) {
                return downloadPartResult2.partNumber - downloadPartResult3.partNumber;
            }
        });
        if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES && this.mRequest.getRange() == null) {
            Long calcObjectCRCFromParts = calcObjectCRCFromParts(downloadFileResult.partResults);
            resumableDownloadResult.setClientCRC(calcObjectCRCFromParts);
            try {
                OSSUtils.checkChecksum(calcObjectCRCFromParts, this.mCheckPoint.fileStat.serverCRC, downloadFileResult.partResults.get(0).requestId);
            } catch (InconsistentException e11) {
                removeFile(this.checkpointPath);
                removeFile(this.mRequest.getTempFilePath());
                throw e11;
            }
        }
        removeFile(this.checkpointPath);
        moveFile(new File(this.mRequest.getTempFilePath()), new File(this.mRequest.getDownloadToFilePath()));
        resumableDownloadResult.setServerCRC(this.mCheckPoint.fileStat.serverCRC);
        resumableDownloadResult.setMetadata(downloadFileResult.metadata);
        resumableDownloadResult.setRequestId(downloadFileResult.partResults.get(0).requestId);
        resumableDownloadResult.setStatusCode(200);
        return resumableDownloadResult;
    }

    protected void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0L;
    }

    protected void processException(Exception exc) {
        synchronized (this.mLock) {
            try {
                this.mPartExceptionCount++;
                if (this.mDownloadException == null) {
                    this.mDownloadException = exc;
                    this.mLock.notify();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    protected void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    protected boolean removeFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
