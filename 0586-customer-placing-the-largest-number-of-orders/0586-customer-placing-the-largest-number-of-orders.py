import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    order_counts=orders['customer_number'].value_counts()
    max_value=order_counts.max()
    return order_counts[order_counts==max_value].index.to_frame()