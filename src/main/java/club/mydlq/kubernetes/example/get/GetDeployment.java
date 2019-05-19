package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.*;
import io.kubernetes.client.models.V1Deployment;
import io.kubernetes.client.models.V1DeploymentList;

/**
 * - 描述：获取 Deployment
 * - API版本： apps/v1
 */
public class GetDeployment {

    /**
     * 获取全部 Namespace 的 Deployment 列表
     */
    public static void getAllDeloyment() throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取全部 Namespace 下的 Deployment 列表
        V1DeploymentList deploymentList = appsV1Api.listDeploymentForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Deployment item : deploymentList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Deployment 列表
     */
    public static void getNamespaceDeloymentList(String namespace) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Deployment 列表
        V1DeploymentList deploymentList = appsV1Api.listNamespacedDeployment(namespace, null, null, null, null, null, null, null, null, null);
        for (V1Deployment item : deploymentList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Deployment
     */
    public static void getNamespaceDeloyment(String namespace,String deploymentName) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Deployment 列表
        V1Deployment deployment = appsV1Api.readNamespacedDeployment(deploymentName , namespace, null, null, null);
        System.out.println(deployment);
    }

    /**
     * 获取 Deployment
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Deployment
        getAllDeloyment();
        // 获取某个 Namespace 下的 Deployment 列表
        getNamespaceDeloymentList("kube-system");
        // 获取某个 Namespace 的某个 Deployment
        getNamespaceDeloyment("kube-system","coredns");
    }

}
