# Parking Lot

## Requirements

### Functional Requirements
- **Multi-Floor Support**: Parking lot has multiple floors and each floor has parking spots
- **Entry/Exit Management**: Multiple entry and exit gates in the ground floor
- **Ticket System**: Customer collects ticket at the entry gate, with entry time and slot number
- **Payment Processing**: Customers make payment on exit gate
- **Capacity Management**: If parking lot is full, no entry allowed
- **Vehicle Types**: Support for different vehicle types - auto, bus, bike, EV vehicles
- **Special Features**: Some parking spots have power plugs for EV charging
- **Flexible Allocation**: Small vehicles can be parked in large vehicle spots
- **Smart Allocation**: Allocate nearest available spot
- **Scalability**: System can be extended with more floors and slots in future

- **Ticket**: Contains Vehicle Number | Entry Gate ID | Entry Time | Slot
- **Bill**: Charges according to spot | Extra charges for electricity usage | Time-based pricing

## System Architecture
classDiagram
    direction TB

    %% Enums
    class VehicleType {
        <<enumeration>>
        BIKE
        AUTO
        CAR
        BUS
    }

    class FuelType {
        <<enumeration>>
        PETROL
        DIESEL
        ELECTRIC
        HYBRID
    }

    class SlotType {
        <<enumeration>>
        SMALL
        MEDIUM
        LARGE
    }

    class SlotStatus {
        <<enumeration>>
        FILLED
        EMPTY
        MAINTENANCE
    }

    class Payment {
        <<enumeration>>
        CASH
        UPI
        CARD
    }

    %% Interfaces
    class SlotAllocationStrategy {
        <<interface>>
        +allocateParkingSlot(vehicle: Vehicle, parkingLot: ParkingLot) ParkingSlot
    }

    class PricingStrategy {
        <<interface>>
        +calculatePrice(ticket: Ticket) double
    }

    %% Models
    class Vehicle {
        -vehicalNo: String
        -vehicleType: VehicleType
        -fuelType: FuelType
        +getVehicalNo(): String
        +getVehicleType(): VehicleType
        +getFuelType(): FuelType
    }

    class ParkingSlot {
        -slotId: String
        -slotType: SlotType
        -currVehicle: Vehicle
        -slotStatus: SlotStatus
        -isChargingAvailable: boolean
        +getSlotId(): String
        +getSlotType(): SlotType
        +getCurrVehicle(): Vehicle
        +getSlotStatus(): SlotStatus
        +isChargingAvailable(): boolean
        +setCurrVehicle(vehicle: Vehicle): void
        +setSlotStatus(status: SlotStatus): void
        +print(): void
    }

    class ParkingFloor {
        -floorId: int
        -parkingSlots: List~ParkingSlot~
        +getFloorId(): int
        +getParkingSlots(): List~ParkingSlot~
        +printSlots(): void
    }

    class EntryGate {
        -entryGateId: String
        +getEntryGateId(): String
        +generateTicket(vehicle: Vehicle, parkingLot: ParkingLot) Ticket
    }

    class ExitGate {
        -exitGateId: String
        +getExitGateId(): String
        +generateBill(ticket: Ticket, pricingStrategy: PricingStrategy) Bill
    }

    class Ticket {
        -ticketId: UUID
        -vehicle: Vehicle
        -parkingSlot: ParkingSlot
        -entryGateId: String
        -entryTime: LocalDateTime
        +getTicketId(): UUID
        +getVehicle(): Vehicle
        +getParkingSlot(): ParkingSlot
        +getEntryGateId(): String
        +getEntryTime(): LocalDateTime
        +printTicket(): void
    }

    class Bill {
        -billId: UUID
        -exitTime: LocalDateTime
        -totalAmount: double
        -ticket: Ticket
        +getBillId(): UUID
        +printBill(): void
    }

    class ParkingLot {
        -parkinglot: List~ParkingFloor~
        -entryGates: List~EntryGate~
        -exitGates: List~ExitGate~
        -slotAllocatioSt: SlotAllocationStrategy
        -pricingStrategy: PricingStrategy
        +getFloors(): List~ParkingFloor~
        +getSlotAllocationStrategy(): SlotAllocationStrategy
        +getPricingStrategy(): PricingStrategy
        +allocateSlot(vehicle: Vehicle) ParkingSlot
    }

    %% Strategy Implementations
    class NearestSlotStrategy {
        +allocateParkingSlot(vehicle: Vehicle, parkingLot: ParkingLot) ParkingSlot
        -isVehicleCompatible(vehicle: Vehicle, slot: ParkingSlot): boolean
    }

    class PerHourPricingSt {
        +calculatePrice(ticket: Ticket) double
    }

    class DynamicPricing {
        +calculatePrice(ticket: Ticket) double
    }

    class Main {
        +main(args: String[]): void
    }

    %% Relationships
    Vehicle --> VehicleType
    Vehicle --> FuelType
    ParkingSlot --> SlotType
    ParkingSlot --> SlotStatus
    ParkingSlot "1" --> "0..1" Vehicle : currVehicle

    ParkingFloor "1" --> "*" ParkingSlot
    ParkingLot "1" --> "*" ParkingFloor
    ParkingLot "1" --> "*" EntryGate
    ParkingLot "1" --> "*" ExitGate
    ParkingLot "1" --> "1" SlotAllocationStrategy
    ParkingLot "1" --> "1" PricingStrategy

    Ticket "1" --> "1" Vehicle
    Ticket "1" --> "1" ParkingSlot
    Bill "1" --> "1" Ticket

    EntryGate --> Ticket : generates
    EntryGate --> ParkingLot : uses
    ExitGate --> Bill : generates
    ExitGate --> PricingStrategy : uses

    SlotAllocationStrategy <|.. NearestSlotStrategy
    PricingStrategy <|.. PerHourPricingSt
    PricingStrategy <|.. DynamicPricing

    Main --> ParkingLot
    Main --> Vehicle
    Main --> EntryGate
    Main --> ExitGate

    %% Notes
    note right of ParkingSlot : isChargingAvailable\nfor EV vehicles
    note right of NearestSlotStrategy : Handles vehicle compatibility\nand EV charging requirements
    note top of Bill : Includes charging cost\nfor EV vehicles


```
src/
├── Main.java
├── models/
│   ├── ParkingLot.java
│   ├── ParkingFloor.java
│   ├── ParkingSlot.java
│   ├── EntryGate.java
│   ├── ExitGate.java
│   ├── Vehicle.java
│   ├── Ticket.java
│   └── Bill.java
├── enums/
│   ├── VehicleType.java
│   ├── SlotType.java
│   ├── SlotStatus.java
│   └── FuelType.java
├── interfaces/
│   ├── PricingStrategy.java
│   └── SlotAllocationStrategy.java
└── strategies/
    └── PerHourPricingSt.java
<!-- ```

 $files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
 javac -d out @files  
 java -cp out src.Main
