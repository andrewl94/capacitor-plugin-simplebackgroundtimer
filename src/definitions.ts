declare module '@capacitor/core' {
  interface PluginRegistry {
    SimpleBgTimer: SimpleBgTimerPlugin;
  }
}

export interface SimpleBgTimerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
