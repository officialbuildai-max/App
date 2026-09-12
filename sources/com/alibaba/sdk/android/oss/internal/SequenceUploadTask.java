package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws IOException, ServiceException, ClientException {
        ObjectOutputStream objectOutputStream;
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap hashMap = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        hashMap.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        try {
                            File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            this.mCRC64RecordFile = file2;
                            if (!file2.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e11) {
                        e = e11;
                    }
                    try {
                        objectOutputStream.writeObject(hashMap);
                        objectOutputStream.close();
                    } catch (IOException e12) {
                        e = e12;
                        objectOutputStream2 = objectOutputStream;
                        OSSLog.logThrowable2Local(e);
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                        super.checkException();
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream2 = objectOutputStream;
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                        throw th;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j11 = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i11 = iArr[0];
        int i12 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long j12 = this.mUploadedLength;
            if (j12 > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i11) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                j12 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j13 = j12;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j13, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i13 + 1))) {
                if (i13 == i12 - 1) {
                    i11 = (int) (this.mFileLength - j11);
                }
                OSSLog.logDebug("upload part readByte : " + i11);
                j11 += (long) i11;
                uploadPart(i13, i11, i12);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017c A[Catch: ClientException -> 0x01c2, ServiceException -> 0x01c4, TryCatch #6 {ClientException -> 0x01c2, ServiceException -> 0x01c4, blocks: (B:33:0x0163, B:34:0x0176, B:36:0x017c, B:38:0x0198, B:40:0x019e, B:42:0x01ac, B:43:0x01c6, B:45:0x01e3), top: B:32:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023a  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015b A[Catch: all -> 0x00d5, TryCatch #13 {all -> 0x00d5, blocks: (B:16:0x0080, B:19:0x0099, B:21:0x00c9, B:22:0x00e1, B:24:0x00fa, B:33:0x011d, B:34:0x012f, B:38:0x0153, B:40:0x015b, B:49:0x015f, B:51:0x0179, B:52:0x0197), top: B:15:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a4 A[Catch: IOException -> 0x010a, TRY_ENTER, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a9 A[Catch: IOException -> 0x010a, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ae A[Catch: IOException -> 0x010a, TRY_LEAVE, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015f A[Catch: all -> 0x00d5, TryCatch #13 {all -> 0x00d5, blocks: (B:16:0x0080, B:19:0x0099, B:21:0x00c9, B:22:0x00e1, B:24:0x00fa, B:33:0x011d, B:34:0x012f, B:38:0x0153, B:40:0x015b, B:49:0x015f, B:51:0x0179, B:52:0x0197), top: B:15:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bc A[Catch: IOException -> 0x01b8, TryCatch #2 {IOException -> 0x01b8, blocks: (B:68:0x01b4, B:59:0x01bc, B:61:0x01c1), top: B:67:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c1 A[Catch: IOException -> 0x01b8, TRY_LEAVE, TryCatch #2 {IOException -> 0x01b8, blocks: (B:68:0x01b4, B:59:0x01bc, B:61:0x01c1), top: B:67:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143 A[Catch: IOException -> 0x010a, TRY_ENTER, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0148 A[Catch: IOException -> 0x010a, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014d A[Catch: IOException -> 0x010a, TRY_LEAVE, TryCatch #9 {IOException -> 0x010a, blocks: (B:26:0x0106, B:28:0x010e, B:30:0x0113, B:74:0x0143, B:76:0x0148, B:78:0x014d, B:42:0x01a4, B:44:0x01a9, B:46:0x01ae), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uploadPart(int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }
}
