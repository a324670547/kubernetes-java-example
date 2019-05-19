package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.BatchV1Api;
import io.kubernetes.client.models.V1Job;
import io.kubernetes.client.models.V1JobList;

/**
 * - 描述：获取 Job
 * - API版本： batch/v1
 */
public class GetJob {

    /**
     * 获取全部 Namespace 的 Job 列表
     */
    public static void getAllJob() throws ApiException {
        // 设置 Api 客户端
        BatchV1Api batchV1Api = new BatchV1Api();
        // 获取某个 Namespace 下的 Job
        V1JobList jobList = batchV1Api.listJobForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Job item : jobList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Job 列表
     */
    public static void getNamespaceJobList(String namespace) throws ApiException {
        // 设置 Api 客户端
        BatchV1Api batchV1Api = new BatchV1Api();
        // 获取某个 Namespace 下的 Job 列表
        V1JobList jobList = batchV1Api.listNamespacedJob(namespace, null, null, null, null, null, null, null, null, null);
        for (V1Job item : jobList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Job
     */
    public static void getNamespaceJob(String namespace, String jobName) throws ApiException {
        // 设置 Api 客户端
        BatchV1Api batchV1Api = new BatchV1Api();
        // 获取某个 Namespace 下的 Job 列表
        V1Job job = batchV1Api.readNamespacedJob(jobName, namespace, null, null, null);
        System.out.println(job);
    }

    /**
     * 获取 Job
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Job
        getAllJob();
        // 获取某个 Namespace 下的 Job 列表
        getNamespaceJobList("namespace");
        // 获取某个 Namespace 的某个 Job
        getNamespaceJob("namespace", "jobName");
    }

}
