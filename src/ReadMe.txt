1. Sample output for only APPLE (product processed)
{
	"type":"apple",
	"quantity" : 10,
	"amount":"10p",
	"operation":""
}
Processing count: 10
Status of Sales are:
Sale type: apple
Quantity sold: 100
Amount sold: £10.00
***********************************
Processing count: 20
Status of Sales are:
Sale type: apple
Quantity sold: 200
Amount sold: £20.00
***********************************
Processing count: 30
Status of Sales are:
Sale type: apple
Quantity sold: 300
Amount sold: £30.00
***********************************
Changed request to:
{
	"type":"apple",
	"quantity" : 20,
	"amount":"12p",
	"operation":""
}
Output:
***********************************
Processing count: 40
Status of Sales are:
Sale type: apple
Quantity sold: 500
Amount sold: £54.00
***********************************
Changed Request to:
{
	"type":"apple",
	"quantity" : 14,
	"amount":"15p",
	"operation":""
}
Output:
***********************************
Processing count: 50
Status of Sales are:
Sale type: apple
Quantity sold: 640
Amount sold: £75.00
***********************************

2. Sample with multiple product type:

Processing count: 10
Status of Sales are:
Sale type: banana
Quantity sold: 10
Amount sold: £1.40
***********************************
Sale type: apple
Quantity sold: 10
Amount sold: £1.00
***********************************
Sale type: kiwi
Quantity sold: 10
Amount sold: £5.50
***********************************
Sale type: blueberry
Quantity sold: 7
Amount sold: £2.38
***********************************
Sale type: strawberry
Quantity sold: 10
Amount sold: £2.00
***********************************
Sale type: watermelon
Quantity sold: 27
Amount sold: £23.62
***********************************
Sale type: melon
Quantity sold: 10
Amount sold: £4.50
***********************************
Sale type: grapes
Quantity sold: 10
Amount sold: £3.00
***********************************

Processing count: 20
Status of Sales are:
Sale type: banana
Quantity sold: 10
Amount sold: £1.40
***********************************
Sale type: apple
Quantity sold: 10
Amount sold: £1.00
***********************************
Sale type: kiwi
Quantity sold: 10
Amount sold: £5.50
***********************************
Sale type: blueberry
Quantity sold: 77
Amount sold: £26.18
***********************************
Sale type: strawberry
Quantity sold: 10
Amount sold: £2.00
***********************************
Sale type: watermelon
Quantity sold: 27
Amount sold: £23.62
***********************************
Sale type: melon
Quantity sold: 10
Amount sold: £4.50
***********************************
Sale type: grapes
Quantity sold: 10
Amount sold: £3.00
***********************************

Processing count: 30
Status of Sales are:
Sale type: banana
Quantity sold: 10
Amount sold: £1.40
***********************************
Sale type: apple
Quantity sold: 110
Amount sold: £21.00
***********************************
Sale type: kiwi
Quantity sold: 10
Amount sold: £5.50
***********************************
Sale type: blueberry
Quantity sold: 77
Amount sold: £26.18
***********************************
Sale type: strawberry
Quantity sold: 10
Amount sold: £2.00
***********************************
Sale type: watermelon
Quantity sold: 27
Amount sold: £23.62
***********************************
Sale type: melon
Quantity sold: 10
Amount sold: £4.50
***********************************
Sale type: grapes
Quantity sold: 10
Amount sold: £3.00
***********************************