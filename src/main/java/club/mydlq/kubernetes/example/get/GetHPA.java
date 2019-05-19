package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.AutoscalingV2beta1Api;
import io.kubernetes.client.models.V2beta1HorizontalPodAutoscaler;
import io.kubernetes.client.models.V2beta1HorizontalPodAutoscalerList;

/**
 * - 描述：获取 HorizontalPodAutoscaler
 * - API版本： autoscaling/v2Alpha1
 */
public class GetHPA {

    /**
     * 获取全部 Namespace 的 HPA 列表
     */
    public static void getAllHPA() throws ApiException {
        // 设置 Api 客户端
        AutoscalingV2beta1Api autoscalingV2beta1Api = new AutoscalingV2beta1Api();
        // 获取全部 Namespace 的 HPA 列表
        V2beta1HorizontalPodAutoscalerList HPAList = autoscalingV2beta1Api.listHorizontalPodAutoscalerForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V2beta1HorizontalPodAutoscaler item : HPAList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 HPA 列表
     */
    public static void getNamespaceHPAList(String namespace) throws ApiException {
        // 设置 Api 客户端
        AutoscalingV2beta1Api autoscalingV2beta1Api = new AutoscalingV2beta1Api();
        // 获取某个 Namespace 的 HPA 列表
        V2beta1HorizontalPodAutoscalerList HPAList = autoscalingV2beta1Api.listNamespacedHorizontalPodAutoscaler(namespace, null, null, null, null, null, null, null, null, null);
        for (V2beta1HorizontalPodAutoscaler item : HPAList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 HPA
     */
    public static void getNamespaceHPA(String namespace, String HPAName) throws ApiException {
        // 设置 Api 客户端
        AutoscalingV2beta1Api autoscalingV2beta1Api = new AutoscalingV2beta1Api();
        // 获取某个 Namespace 下的 HPA
        V2beta1HorizontalPodAutoscaler HPA = autoscalingV2beta1Api.readNamespacedHorizontalPodAutoscaler(HPAName, namespace, null, null, null);
        System.out.println(HPA);
    }

    /**
     * 获取 HPA
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 HPA
        getAllHPA();
        // 获取某个 Namespace 下的 HPA 列表
        getNamespaceHPAList("namespace");
        // 获取某个 Namespace 的某个 HPA
        getNamespaceHPA("namespace", "HPAName");
    }

}
