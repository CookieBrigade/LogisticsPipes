package logisticspipes.interfaces.routing;

import java.util.Map;

import logisticspipes.routing.FluidLogisticsPromise;
import logisticspipes.routing.order.IOrderInfoProvider;
import logisticspipes.routing.order.IOrderInfoProvider.ResourceType;
import logisticspipes.utils.FluidIdentifier;

public interface IProvideFluids extends IProvide {

	public Map<FluidIdentifier, Integer> getAvailableFluids();

	public IOrderInfoProvider fullFill(FluidLogisticsPromise promise, IRequestFluid destination, ResourceType type, IAdditionalTargetInformation info);

}
