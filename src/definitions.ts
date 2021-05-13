declare module '@capacitor/core' {
  interface PluginRegistry {
    SimpleBgTimer: SimpleBgTimerPlugin;
  }
}

export interface SimpleBgTimerPlugin {
  startInterval(options: { interval: string }): Promise<{ value: boolean }>;

  stopInterval(options: {}): Promise<{ value: boolean }>;
}
