import { Item } from './Item';
export interface Bill {
    id: number,
    buyerId: number,
    type: string,
    date: string,
    remarks: string,
    item: Item[],
    amount: number



}